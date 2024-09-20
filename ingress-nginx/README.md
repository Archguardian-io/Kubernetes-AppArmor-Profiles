# AppArmor and Seccomp profiles for ingress-nginx
## Command that was used for running ingress-nginx
&nbsp;
```bash
helm install ingress-nginx ingress-nginx/ingress-nginx --version 4.10.1
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
dirb http://${1}:80 ||:
```
## Bash script to update the helm chart
&nbsp;
```bash
dir=$(realpath $(dirname $0))
yq -i ".controller.podAnnotations = \"PLACEHOLDER\"" $dir/values.yaml
sed -i "s|PLACEHOLDER|{container.apparmor.security.beta.kubernetes.io/controller: localhost/registry.k8s.ioingress-nginxcontroller.aa}|" $dir/values.yaml
yq -i ".controller.image.seccompProfile.type = \"Localhost\"" $dir/values.yaml
yq -i ".controller.image.seccompProfile.localhostProfile = \"registry.k8s.ioingress-nginxcontroller.sc\"" $dir/values.yaml
```
