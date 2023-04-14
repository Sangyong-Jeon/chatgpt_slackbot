# ChatGPT 슬랙봇(SlackBot)

## 기획 배경

슬랙으로 커뮤니케이션을 사용한다고 가정하고, 업무적인 간단한 정보를 얻을 때 ChatGPT로 빠른 정보를 얻고 싶었다. 많은 경험이 없는 신입 또는 주니어 개발자에게는 내가 작성한 코드에서 주의할 점이나 고민해야할 점을 빠르게 얻을 수 있었기 때문이다. 또한, 채널에서 ChatGPT에게 물어본다면 그것을 본 다른 시니어 개발자가 다른 피드백이나 다른 조언을 해줄 수 있기 때문에 좋아보였다.

## 구조

<img width="1006" alt="image" src="https://user-images.githubusercontent.com/80039556/232029310-b19d0754-731b-43d1-8fb6-8e8793159c2b.png">

1. 슬랙에서 "/gpt 질문하기" 를 입력함
2. Slash Commands로 설정한대로 "/gpt 질문하기"를 서버로 요청보냄
3. 서버는 요청을 받아서 적절한 처리 후 "질문하기"를 ChatGPT에게 요청함
4. ChatGPT에게 응답을 받으면 슬랙에 응답해줌

## 기술 스택
- Java
- SpringBoot
- Slack SDK Bolt
- Oracle Cloud Infrastructure

슬랙에서 서버로 신호를 보내는 방법은 정말 다양하게 있지만, 그 중 Slash Commands(슬래시 명령어)를 통해 "/gpt" 명령어를 사용하면 특정 주소로 요청하게 만들었다.
슬랙에서 질문하면 서버가 24시간 응답해야하므로 오라클 클라우드를 통해 서버를 구동시켰다.

## 시연

<img width="1083" alt="image" src="https://user-images.githubusercontent.com/80039556/232031202-0eb27e84-9598-477e-8776-8dd9cd2fe920.png">

슬랙 앱에 내가 만든 앱을 설치하고 어느 채널에서든지 "/gpt 질문하기"를 통해 ChatGPT에게 답변을 받을 수 있다.

![슬랙봇_시연](https://user-images.githubusercontent.com/80039556/232034515-ec033ca9-35bf-4595-a6e2-dd0ca7789b94.gif)
