* ensure minikube setup
  * `eval $(minikube docker-env)`
* build docker image
  * `docker build -t boot-mvc-sqs .`
* deploy on minikube
  * `kubectl run squid --image=boot-mvc-sqs --port=8080 --image-pull-policy=IfNotPresent`
  * `kubectl create -f k8s/deployment.yaml`
* create k8s service
  * `kubectl create -f k8s/service.yaml`
  * `minikube service sqs-service`
* follow logs
  * `kubectl logs -f [POD NAME e.g.,  sqs-deployment-7fb9f7bbd7-rjc8f] `