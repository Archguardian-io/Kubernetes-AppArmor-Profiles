{
    "defaultAction": "SCMP_ACT_ERRNO",
    "defaultErrnoRet": 1,
    "archMap": [
        {
            "architecture": "SCMP_ARCH_X86_64",
            "subArchitectures": [
                "SCMP_ARCH_X86",
                "SCMP_ARCH_X32"
            ]
        }
    ],
    "syscalls": [
        {
            "names": [
                "ftruncate",
                "unlink",
                "seccomp",
                "arch_prctl",
                "fsync",
                "nanosleep",
                "socketpair",
                "rename",
                "clock_nanosleep",
                "mknodat",
                "rt_sigprocmask",
                "pwrite64",
                "pipe2",
                "rt_sigaction",
                "futex",
                "set_tid_address",
                "accept",
                "statfs",
                "mprotect",
                "unlinkat",
                "mremap",
                "pwritev",
                "wait4",
                "setns",
                "chmod",
                "utimensat",
                "setgroups",
                "close",
                "mkdirat",
                "setsockopt",
                "shmctl",
                "fstat",
                "fcntl",
                "prlimit64",
                "getpgrp",
                "geteuid",
                "faccessat",
                "prlimit",
                "shmdt",
                "getrlimit",
                "recv",
                "setitimer",
                "recvfrom",
                "dup2",
                "getuid",
                "capget",
                "fchownat",
                "keyctl",
                "unshare",
                "read",
                "setsid",
                "getrandom",
                "ioctl",
                "umask",
                "access",
                "sysinfo",
                "vfork",
                "getsockopt",
                "socket",
                "uname",
                "brk",
                "dup",
                "pread64",
                "epoll_create1",
                "fchown",
                "chdir",
                "truncate",
                "write",
                "recvmsg",
                "getsockname",
                "epoll_pwait",
                "dup3",
                "pread",
                "sethostname",
                "execve",
                "fallocate",
                "getgid",
                "readlink",
                "rmdir",
                "statx",
                "mkdir",
                "setuid",
                "pivot_root",
                "prctl",
                "sync_file_range",
                "recvmmsg",
                "accept4",
                "getcwd",
                "rt_sigreturn",
                "epoll_ctl",
                "mmap",
                "clone3",
                "shmat",
                "capset",
                "fadvise64",
                "getrusage",
                "faccessat2",
                "umount2",
                "bind",
                "getpid",
                "getppid",
                "rseq",
                "madvise",
                "clone",
                "copy_file_range",
                "symlinkat",
                "epoll_wait",
                "sched_yield",
                "readlinkat",
                "pwrite",
                "set_robust_list",
                "munmap",
                "getegid",
                "sigaltstack",
                "connect",
                "signalfd4",
                "shutdown",
                "lseek",
                "sched_getaffinity",
                "listen",
                "exit_group",
                "fdatasync",
                "fstatfs",
                "getdents64",
                "mount",
                "kill",
                "fchdir",
                "gettid",
                "poll",
                "setgid",
                "fchmodat",
                "newfstatat",
                "shmget",
                "openat",
                "tgkill",
                "sendto"
            ],
            "action": "SCMP_ACT_ALLOW"
        }
    ]
}