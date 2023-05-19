
# 1. Model
![image](https://github.com/computer98400/foodDelivery_lv3/assets/62691610/cf198647-a5c3-41f1-ae33-f6d5230ef944)

# 2. Pub / Sub
![image](https://github.com/computer98400/foodDelivery_lv3/assets/62691610/08fa65b6-9155-4070-b9da-fac91ca083b3)
3번에서의 오류로 인해 해당 Pub/ Sub 내용은 로컬 환경에서 실행한 사진을 올렸습니다.

# 3. Service Router
![image](https://github.com/computer98400/foodDelivery_lv3/assets/62691610/68d4a08a-23cd-4fe7-aa43-1133e30254f9)
해당 내용 적용시키기 위해 명령어 작업중 `kubectl apply -f template` 명령을 실행하게 되면 timeout 오류가 나게되어 진행이 불가능했습니다.


문제 해결을 위해 실행한 명령어
```
   16  aws eks update-kubeconfig --name user06-eks
   17  eksctl get clusters
   18  docker login
   19  cd kubenetes;
   20  cd kubernetes/
   21  kubectl apply -f template.yml
   22  kubectl apply -f template.ymlkubectl get all
   23  kubectl get all
   24  kubectl apply -f template.yml
   25  kubectl
   26  kubectl apply -f template.yml 
   27  kubectl config view
   28  kubectl config use-context CONTEXT-CHOSEN-FROM-PREVIOUS-COMMAND-OUTPUT
   29  kubectl config use-context kubectl apply -f template.yml
   30  kubectl config use-context 'kubectl apply -f template.yml'
   31  kubectl config use-context 'kubectl apply -f template.yml'
   32  kubectl apply -f template.yml 
   33  minikube start
   34  kubectl config use-context minikube\
   35  kubectl config use-context minikube
   36  kubectl config get-contexts
   37  kubectl config use-context docker-for-desktop
   38  kubectl
   39  kubectl apply -f template.yml
   40  kubectl version
   41  brew install kubectl
   42  minikube start
   43  brew cask install minikube
   44  brew --cask install minikube
   45  brew install --cask minikube
   46  brew install minikube
   47  minikube start
   48  kubectl config view
   49  kubectl config use-context arn:aws:eks:ap-southeast-2:740310566261:cluster/user06-eks
   50  kubectl apply -f template.yml 
   51  kubectl config use-context 740310566261:cluster/user06-eks
   52  kubectl config use-context ap-southeast-2:740310566261:cluster/user06-eks
   53  kubectl config use-context eks:ap-southeast-2:740310566261:cluster/user06-eks
   54  kubectl config use-context aaws:eks:ap-southeast-2:740310566261:cluster/user06-eks
   55  kubectl config use-context aws:eks:ap-southeast-2:740310566261:cluster/user06-eks
   56  kubectl config use-context arn:aws:eks:ap-southeast-2:740310566261:cluster/user06-eks
   57  kubectl apply -f template.yml 
   58  kubectl --request-timeout "6000"
   59  kubectl --request-timeout "10m"
   60  kubectl apply -f template.yml 
   61  kubectl create deploy order --image=yunseol/order:v1
   62  aws eks update-kubeconfig --name user06-eks
   63  kubectl apply -f template.yml 
   64  kubectl create deployment nginx --image=nginx
   65  kubectl get deploy -o wide
   66  kubectl get pod -o wide
   67  history
```


1. minikube
기존 kubenetes의 무거움이 문제일 꺼라 생각하여 minikube를 통해 배포 진행.
-> `kubectl use-context `내용에 어떤 값을 넣어야될지 몰라서 실패

2. 연결 시간 늘리기.
kubenetes 연결의 시간이 짦아서 연결이 안되는거라 생각.
-> 각 pods에 대한 연결시간을 설정하는 것이기 때문에 실패
