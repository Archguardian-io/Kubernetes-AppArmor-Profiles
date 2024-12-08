# AppArmor and Seccomp profiles for redis
## Command that was used for running redis
&nbsp;
```bash
helm install redis bitnami/redis --version 20.0.3
```
## Tests for profiling the container
&nbsp;
```bash
until redis-cli -p 6379 -h $1 ping
do
  sleep 2
done

redis-cli -p 6379 -h $1 ping ||:
redis-cli -p 6379 -h $1 set foo bar ||:
redis-cli -p 6379 -h $1 get foo  ||:
redis-cli -p 6379 -h $1 ping ||:
redis-cli -p 6379 -h $1 set foo bar ||:
redis-cli -p 6379 -h $1 get foo  ||:
redis-cli -p 6379 -h $1 ping ||:
redis-cli -p 6379 -h $1 set foo bar ||:
redis-cli -p 6379 -h $1 get foo  ||:
```
## Bash script to update the helm chart
&nbsp;
```bash
dir=$(realpath $(dirname $0))
sed -i '0,/^  podAnnotations/{s|^  podAnnotations.*|  podAnnotations: {container.apparmor.security.beta.kubernetes.io/redis: localhost/bitnamiredis.aa}|}' $dir/values.yaml
yq -i ".master.containerSecurityContext.seccompProfile.type = \"Localhost\"" $dir/values.yaml
yq -i ".master.containerSecurityContext.seccompProfile.localhostProfile = \"bitnamiredis.sc\"" $dir/values.yaml
```
