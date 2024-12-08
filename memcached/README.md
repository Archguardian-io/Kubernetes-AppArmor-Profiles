# AppArmor and Seccomp profiles for memcached
## Command that was used for running memcached
&nbsp;
```bash
helm install memcached bitnami/memcached --version 7.4.11
```
## Tests for profiling the container
&nbsp;
```bash
until echo "stats" | nc -w1 $1 11211
do
  sleep 2
done

echo "stats" | nc -w1 $1 11211 ||:
echo "set foo 0 0 3\r\nbar\r\n" | nc -w1 $1 11211 ||:
echo "get foo" | nc -w1 $1 11211 ||:
echo "set foo 0 0 3\r\nbar\r\n" | nc -w1 $1 11211 ||:
echo "get foo" | nc -w1 $1 11211 ||:
echo "set foo 0 0 3\r\nbar\r\n" | nc -w1 $1 11211 ||:
echo "get foo" | nc -w1 $1 11211 ||:
echo "stats" | nc -w1 $1 11211 ||:
```
## Bash script to update the helm chart
&nbsp;
```bash
dir=$(realpath $(dirname $0))
sed -i "/^podAnnotations.*/ s|{}|{container.apparmor.security.beta.kubernetes.io/memcached: localhost/bitnamimemcached.aa}|" $dir/values.yaml
yq -i ".containerSecurityContext.seccompProfile.type = \"Localhost\"" $dir/values.yaml
yq -i ".containerSecurityContext.seccompProfile.localhostProfile = \"bitnamimemcached.sc\"" $dir/values.yaml
```
