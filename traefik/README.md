# AppArmor and Seccomp profiles for traefik
## Command that was used for running traefik
&nbsp;
```bash
helm install traefik traefik/traefik --version 30.1.0
```
## Tests for profiling the container
&nbsp;
```bash
until curl -Ls $1
do
  sleep 2
done

curl -Ls $1
curl -Ls $1
curl -Ls $1
curl -Ls ${1}/index.html
curl -Ls ${1}/robots.txt
curl -Ls ${1}/404.html
dirb http://${1}:80
```
## Bash script to update the helm chart
&nbsp;
```bash
dir=$(realpath $(dirname $0))
sed -i "/podAnnotations.*/ s|{}|{container.apparmor.security.beta.kubernetes.io/traefik: localhost/traefik.aa}|" $dir/values.yaml
yq -i ".securityContext.seccompProfile.type = \"Localhost\"" $dir/values.yaml
yq -i ".securityContext.seccompProfile.localhostProfile = \"traefik.sc\"" $dir/values.yaml
```
