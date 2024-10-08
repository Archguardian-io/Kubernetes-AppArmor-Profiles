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
                "getsockname",
                "fcntl",
                "connect",
                "rt_sigaction",
                "execve",
                "getrlimit",
                "mknodat",
                "bind",
                "newfstatat",
                "nanosleep",
                "fork",
                "clone",
                "close",
                "futex",
                "socketpair",
                "socket",
                "readlinkat",
                "unlinkat",
                "getsockopt",
                "uname",
                "read",
                "getppid",
                "setsockopt",
                "fchown",
                "rt_sigprocmask",
                "fstat",
                "getdents64",
                "ioctl",
                "setuid",
                "faccessat",
                "epoll_pwait",
                "rt_sigreturn",
                "unshare",
                "openat",
                "mkdir",
                "madvise",
                "setsid",
                "dup3",
                "prlimit",
                "write",
                "pread",
                "capget",
                "getcwd",
                "arch_prctl",
                "open",
                "prctl",
                "mmap",
                "accept4",
                "epoll_create1",
                "faccessat2",
                "brk",
                "getuid",
                "sendto",
                "keyctl",
                "getrandom",
                "capset",
                "prlimit64",
                "pivot_root",
                "dup2",
                "statfs",
                "sigaltstack",
                "mount",
                "sched_yield",
                "chdir",
                "seccomp",
                "mkdirat",
                "pipe2",
                "setns",
                "wait4",
                "epoll_ctl",
                "listen",
                "getpeername",
                "fchdir",
                "gettid",
                "umask",
                "setgid",
                "exit_group",
                "setgroups",
                "sched_getaffinity",
                "clone3",
                "set_tid_address",
                "umount2",
                "sendmmsg",
                "symlinkat",
                "fchownat",
                "fstatfs",
                "pread64",
                "stat",
                "mprotect",
                "set_robust_list",
                "rseq",
                "getgid",
                "sendmsg",
                "getpid",
                "accept",
                "munmap",
                "sethostname",
                "geteuid",
                "tgkill"
            ],
            "action": "SCMP_ACT_ALLOW"
        }
    ]
}