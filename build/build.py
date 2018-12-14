from functools import partial
from hashlib import sha256
from pathlib import Path
from typing import Dict, Callable, Any, NamedTuple, Iterable
import os
import shelve
import subprocess
import time

def main() -> None:
    source = Path("../Computer Science")
    target = Path("/Users/Noel/Google Drive/Noel's Notes/Computer Science")
    d = process_changed_files(load_data(), source, skip_hidden_files(partial(pandoc_and_link, target)))
    store_data(d)

def load_data() -> Dict[Path, "Data"]:
    with shelve.open("filedata.db") as db:
        return db.get("data", {})

def store_data(d: Dict[Path, "Data"]) -> None:
    with shelve.open("filedata.db") as db:
        db["data"] = d

def process_changed_files(db: Dict[Path, "Data"], root: Path, build_file: Callable[[Path, Path], bool]) -> Dict[Path, "Data"]:
    fs = list(changed_files(db, root))
    c = 1
    l = len(fs)
    t1 = time.time()
    print(f"Starting files at {t1}")
    for f in fs:
        print(f"Doing file {c} of {l} ({f.name})…")
        c += 1
        p = Path(f)
        if build_file(root, p):
            db = store_hash(db, p)
    t2 = time.time()
    print(f"Finished at {t2}")
    print(f"Ran for {(t2 - t1) / 60} minutes")
    return db

def changed_files(db: Dict[Path, "Data"], root: Path) -> Iterable[Path]:
    for dirpath, ds, fs in os.walk(root):
        for f in fs:
            p = Path(os.path.join(dirpath, f))
            if recently_modified(db, p) and hash_changed(db, p):
                yield p

def skip_hidden_files(f: Callable[[Path, Path], bool]) -> Callable[[Path, Path], bool]:
    def g(r: Path, p: Path) -> bool:
        if p.name.startswith("."):
            return False
        else:
            return f(r, p)
    return g

def pandoc_and_link(d: Path, s: Path, f: Path) -> bool:
    if f.suffix == ".md":
        pandoc(d, s, f)
    else:
        link(d, s, f)
    return True

def pandoc(destination: Path, source: Path, f: Path) -> None:
    d = destination / f.relative_to(source)
    d.parent.mkdir(parents=True, exist_ok=True)
    subprocess.run([
        "pandoc", f, "-o", d.with_suffix('.pdf'),
        "-s",
        "--highlight-style", "tango",
        "--pdf-engine=xelatex",
        "-V", "margin-top=1in",
        "-V", "margin-bottom=1in",
        "-V", "margin-left=1.25in",
        "-V", "margin-right=1.25in",
        "-V", "mainfont=Source Serif Pro",
        "-V", "sansfont=Source Sans Pro",
        "-V", "monofont=Source Code Pro",
        "-V", "fontsize=12pt",
        f"--resource-path={d.parent}",
        ],
        capture_output=True)

def link(destination: Path, source: Path, f: Path) -> bool:
    d = destination / f.relative_to(source)
    d.parent.mkdir(parents=True, exist_ok=True)
    cp = subprocess.run(["ln", f, d], capture_output=True)
    if cp.returncode != 0:
        print(f"Got error when linking: {cp}")
        return False
    else:
        return True

def print_file(r: Path, f: Path) -> bool:
    print(f"Building {f}…")
    return True

def recently_modified(db: Dict[Path, "Data"], f: Path) -> bool:
    data = db.get(f)
    stat = os.stat(f)
    return data is None or data.time != stat.st_mtime

def hash_changed(db: Dict[Path, "Data"], f: Path) -> bool:
    data = db.get(f)
    return data is None or data.hash != hash_file(f)

def store_hash(db: Dict[Path, "Data"], f: Path) -> Dict[Path, "Data"]:
    db[f] = Data(hash = hash_file(f), time = os.stat(f).st_mtime)
    return db

def hash_file(f: Path) -> bytes:
    with open(f, 'br') as fh:
        return sha256(fh.read()).digest()

class Data(NamedTuple):
    hash: bytes
    time: int

    def with_hash(self, h: bytes) -> "Data":
        return Data(hash = h, time = self.time)

    def with_time(self, t: int) -> "Data":
        return Data(hash = self.hash, time = t)

    @classmethod
    def empty(cls) -> 'Data':
        return Data(hash=b"", time=0)

if __name__ == '__main__':
    main()
