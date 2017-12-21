# Filesystem

---

## Links

Links save space by having multiple references to a file. There are two main types, hard and soft:

### Hard Links

A hard link is a link to the file inode. They are independent of one another. If you delete one, the others remain.

### Soft Links

A soft link is a link to the directory entry. If you move/rename the original file, the link is broken.

## Inodes

Index nodes are a control structure that contains key information for a particular file. Ownership, timestamp, etc, as well as pointers to the data itself on the disk.