## 네트워크

### 네트워크에서 서버와 클라이언트는 각각 어떤 역할을 하나요?
- 클라이언트
    - 서버에게 어떠한 작업을 요청하고 작업 결과를 반환 받는 역할
- 서버
    - 클라이언트에게 요청 받은 작업을 완료하고 작업 결과를 반환하는 역할
- 클라이언트-서버 모델의 특징
    - 요청-응답 구조, 해당 모델에서 통신 구조는 항상 요청-응답 구조인 형태
    - 다중 요청에 대해서 동시적으로 처리할 수 있는 모델 구조

### HTTP와 HTTPS의 차이점은 무엇인가요?
- HTTP(HyperText Transfer Protocol)
    - 웹 브라우저와 웹 서버간의 자원을 주고 받는 프로토콜
    - 암호화 되지 않은 평문으로 데이터가 주고받을 수 있기에 보안 측면에서 취약한 프로토콜
    - Port Number: 80
- HTTPS (HyperText Transfer Protocol Secure)
    - HTTP에 **SSL/TLS 암호화** 기술을 추가하여 보안성을 높인 프로토콜
    - 클라이언트(웹 브라우저)와 서버 간의 모든 통신이 암호화 되어 통신이 진행
    - Port Number: 443
- SSL과 TLS
    - SSL(Secure Sockets Layer)은 웹 브라우저와 웹 서버 간의 통신 시 데이터를 암호화하는 프로토콜
    - TLS(Transport Layer Security)은 SSL에서의 보안 취약점과 암호화 알고리즘이 강화된 프로토콜
- HTTPS에서의 SSL, TLS 동작 과정
    1. Client Hello 진행(클라이언트에서 자신이 사용하는 암호화 방식, 정보 제공)
    2. Server Hello 진행(클라이언트가 보내준 정보를 참고하여 서버 측에서 사용하는 암호화 방식 및 CA 인증서 응답)
    3. 서버 인증서 확인(클라이언트 측에서 서버가 보내준 CA 인증서 리스트 확인)
    4. 대칭 키 교환
    5. 대칭 키를 통해 암호화된 데이터 송수신

### TCP와 UDP의 차이점은 무엇인가요?
- TCP
    - 신뢰성 기반 프로토콜
    - 데이터를 송수신 하기 전에 미리 연결을 하고 진행하기에 연결 지향적
    - 데이터가 손실 되지 않고 데이터 수신의 순서성을 보장
    - 이처럼 신뢰성 기반을 보장하기에 UDP에 비해 오버헤드가 높고 속도가 느림
- UDP
    - 비 신뢰성 기반 프로토콜
    - 통신 전 클라이언트와 서버간의 연결 과정 없이 데이터를 보냄
    - 데이터의 오류 검사나 재전송을 진행하지 않음
    - 패킷의 수신 순서성 보장하지 않음
    - 이처럼 신뢰성을 보장하는 작업이 없기에 데이터 송수신 속도가 빠름

### IP 주소란 무엇이며, 어떻게 분류되나요?
- IP
    - Internet Protocol Address는 인터넷에 존재하는 컴퓨터의 고유 번호를 나타내는 것
    - IPv4: 32 비트의 IP 주소 체계, ex) 192.0.0.1
    - IPv4: 128 비트의 IP 주소 체계, ex) 2001:0db8:85a3:0000:0000:8a2e:0370:7334
- IP 주소 Class
    - Class A: 최상위 비트가 0인 IP 주소 목록을 Class A로 지칭, 가장 많은 호스트 수를 차지함
    - Class B: 최상위 비트가 1인 IP 주소 목록을 Class B로 지칭
    - Class C: 최상위 비트가 11인 IP 주소 목록을 Class C로 지칭
    - Class D: 최상위 비트가 111인 IP 주소 목록을 Class D로 지칭
    - Class E: 최상위 비트가 1111인 IP 주소 목록을 Class E로 지칭

### OSI 7계층 모델을 설명해주세요.
7. Application Layer(응용 계층)
- 역할: 사용자와 직접적으로 상호작용 하는 계층이며 응용 프로그램을 운영체제에 종속 시킴(OSI 7 Layer에서는 네트워크 송수신을 진행할 때 운영 체제의 네트워크 스택을 이용하기에 응용 프로그램을 OS에 종속 시켜야 함)
- 프로토콜: HTTP, FTP, SMTP, SSH …

6. Presentation Layer(표현 계층)
- 역할: 응용 계층으로부터 전달 받은 데이터를 수신 측에서 받을 수 있는 데이터 형식으로 변환하거나 데이터를 압축하고 암호화 함
- 프로토콜: JPEG, MPEG, SSL, TLS

5. Session Layer(세션 계층)
- 역할: 통신을 위한 세션에 대해서 연결하거나 해제하는 등의 세션 관리를 진행
- 프로토콜: NetBIOS, RPC, NFS
- 
4. Transport Layer(전송 계층)
- 역할: 데이터를 세그먼트 형식으로 나눈 후에, 송신 순서나 오류 검사 등의 처리를 진행하며 TCP/UDP에 대한 프로토콜 결정
- 프로토콜: TCP, UDP

3. Network Layer(네트워크 계층)
- 역할: 패킷이 생성되며, IP 주소를 사용하여 데이터를 목적지까지 전달하는 경로를 설정
- 프로토콜: IP, ICMP, ARP, RARP

2. Data Link Layer(데이터 링크 계층)
- 역할: 패킷을 프레임 형식으로 변환하며 MAC 주소를 통해 데이터 링크를 설정합니다. 이 단계에서는 오류 검출과 수정 또한 진행
    - MAC 주소란 네트워크 장치(컴퓨터, 스마트폰 ..)에 존재하는 네트워크 인터페이스 카드(NIC)에 존재하는 고유 번호로 IP에서 존재하는 특정 장치에 라우팅 하기 위한 주소를 의미
- 프로토콜: Ethernet, Token Ring, FDDI, HDLC

1. Physical Layer(물리 계층)
- 역할: 데이터는 실제 전기적 신호로 변환되어 네트워크 매체를 통해 전송하는 역할, 실질적으로 네트워크의 물리적인 통신은 물리 계층에서 진행
- 프로토콜: RS-232C, V.35, Ethernet, FDDI

### TCP/IP 모델을 OSI 모델과 비교하여 설명해주세요.
- TCP/IP 모델
    - 4 Layer 형식으로 구성 됨(Presentation Layer와 Session Layer의 기능을 Application Layer에 통합, Data Link Layer와 Physical Layer를 Network Access Layer에 통합시킨 구조)
    - Application Layer / Transport Layer / Internet Layer / Network Access Layer(네트워크 인터페이스 계층)
    - OSI는 네트워크 통신에 대한 계층을 이론적으로 표현하기에 적합한 모델이고 실질적인 네트워크 통신 시 사용되는 모델은 TCP/IP 4 Layer Model을 주로 사용

### DNS의 역할은 무엇이며, 작동 방식은 어떻게 되나요?
- DNS는 도메인 이름을 IP 주소로 변환해주는 시스템을 말함, IP 주소는 사람이 기억하기 어렵기에 도메인 네임을 사용하는데 실제로 네트워크 통신 시 사용 되는 것은 IP 주소이기에 이를 변환해야 함, 또한 하나의 도메인 이름에 여러 IP 주소가 매핑 되어 있는 경우 로드 밸런싱을 지원하기도 함
- 작동 방식
    1. 사용자가 입력한 도메인 이름에 대해서 DNS 리졸버가 캐시에서 IP 주소가 있는지 확인
    2. 없는 경우 **Root DNS 서버** → **TLD DNS 서버** → **Authoritative DNS 서버**를 차례로 조회
    3. 조회한 IP 주소를 도메인 리졸버가 사용자에게 반환
    - Root DNS 서버: 최상위의 DNS 서버로, 전체 DNS 계층 구조의 시작점, www.naver.com인 경우 .com과 같은 TLD에 대한 정보만을 가지고 있는 서버
    - TLD(Top-Level Domain) DNS 서버: 풀 도메인 네임(naver.com)에 대한 정보에 대한 권한을 가지고 있는 Authenctication DNS 서버의 위치 주소를 가지고 있는 서버
    - Authoritative DNS 서버: 실제로 www.naver.com의 IP 주소를 가지고 있는 서버로써 이 IP 주소를 DNS 리졸버에게 반환하는 서버

### ARP(주소 결정 프로토콜)란 무엇이며, 어떻게 작동하나요?
- ARP(주소 결정 프로토콜)
    - 네트워크에서 IP 주소를 물리적 주소(MAC 주소)로 변환해주는 프로토콜
    - IP 주소를 통하여 네트워크 라우팅 → 로컬 네트워크에서 MAC 주소 확인 → IP와 MAC 주소를 통하여 실제 네트워크 장치의 위치 확인
- 작동 방식(Host A → Host B로 데이터 전송 하는 것을 전제로 함)
    
    1. ARP 요청
    - Host A가 Host B의 IP에 있는 모든 Host에게 Broad Cast 방식으로 MAC 주소 요청
      
    2. ARP 응답
    - 자신의 IP에 해당하는 Host가 MAC 주소를 Unicast 방식으로 반환
    
    3. ARP 캐시 저장
    - 호스트 A는 ARP 응답 값을 캐시에 일정 시간 저장한 후 동일한 IP 요청이 오면 ARP 요청을 진행하지 않고 ARP 캐시에서 조회

### NAT(Network Address Translation)란 무엇인가요?
- **사설 IP 주소**와 **공용 IP 주소** 간의 변환하는 기술
- 여러 개의 사설 IP가 하나의 공용 IP로 매핑 될 때 아웃바운드 또는 인바운드 통신이 진행될 때 적절하게 IP 주소를 변경해줌 → 사설 IP를 외부에 노출시키지 않아서 외부로부터의 직접적인 통신을 막아줘 보안적인 측면에서 이점이 있음

### 네트워크에서 CORS(Cross-Origin Resource Sharing)는 무엇인가요?
- **CORS**란 Cross-Origin Resource Sharing의 약자이며 **교차 출처 자원 공유**를 뜻합니다.
- 이는 어떠한 출처에서 Application을 실행할 때 다른 출처의 리소스에 **접근할 수 있는 권한을 
부여**하는 체제(기법)을 의미합니다.
- 여기서 다른 출처라는 기준은 기존의 출처와 프로토콜, 도메인, 포트번호 등등이 다를 경우 다른 출처(Cross-Origin)가 됩니다.
    - 반대로 같은 출처는 Same-Origin으로 불립니다.
- 일반적으로 브라우저에서는 다른 출처간의 통신(요청)을 제한하기에 CORS를 통해 이러한 
제한을 풀고 통신을 진행합니다.
    - 하지만 다른 출처간의 통신이 어떠한 조건 없이 진행된다면 사용자 공격에 매우 취약합니다.
    - 그렇기에 CORS를 통한 통신은 추가 HTTP Header를 이용하여 진행합니다.
- 이러한 CORS를 통한 **요청 정책**은 크게 3가지가 존재합니다.
    
    1) **Simple Request(단순요청)**
    - 브라우저는 자신의 주소를 origin이라는 헤더에 담아서 요청을 보냅니다.
    - 서버는 해당 요청을 확인하고 브라우저의 주소에 접근이 가능하다는 access-control-allow-origin 헤더에 브라우저의 주소를 반환합니다.
    - 결과적으로 access-control-allow-origin 헤더에 포함된 값으로 통신이 진행될지 결정합니다.
        - 예를 들어 서버가 헤더에 값을 넣지 않거나 헤더의 값이 브라우저의 주소가 아닌 경우 
        통신은 진행되지 않습니다.
    
    2) **Preflight Request(프리 플라이트)**
    - 이 정책은 HTTP 요청을 미리 보내 실제 요청이 안전한지 확인하는 정책입니다.
    - HTTP 메서드 중 하나인 **OPTIONS** 메서드를 이용하며 origin 헤더에 자신의 주소를 미리 요청(Pre-flight Request)합니다.
        - OPTIONS 메서드를 사용하는 이유는 Pre-flight Request임을 알려주기 위함입니다.
    - 이에 대한 Pre-flight Response를 반환하는데 access-control-allow-origin에 브라우저의 
    주소 값을 가지며 access-control-max-age라는 캐싱 시간(CORS 요청에 대한 유효기간)을 반환합니다.
    - 그 후 실제 요청(Request-origin)과 응답(Response-access-control-allow-origin)을 진행하여 
    CORS 통신을 진행합니다.
    
    3) **Credential Request(신용 요청)**
    - 신용 요청은 쿠키, 인증 헤더, TLS 클라이언트 등의 신용 정보를 함께 요청하며 이러한 정보들을 기반으로 통신을 진행할지 결정합니다.
    - 일반적으로 CORS 정책은 다른 출처 요청에 인증정보를 포함하는 것을 허용하지 않지만 
    access-contol-allow-credentials가 true로 설정 되어 있다면 인증정보를 포함할 수 있습니다.
- 3가지 방법 중 가장 권장되는 정책은 Pre-flight Request로 미리 요청을 보내 검증 할 수 있어 
가장 권장되는 방법입니다.

### TCP 3-way 핸드셰이크 과정은 무엇인가요?
- TCP로 네트워크 데이터 송수신이 진행될 때 클라이언트와 서버 간의 연결이 먼저 진행 되어야 하는데 이 때 진행되는 방법이 TCP 3-way 핸드셰이크
- 동작 과정
    1. 클라이언트가 서버에 연결 요청(SYN)을 보냄.
        - 클라이언트 state: CLOSED → SYN_SENT
    2. 서버가 클라이언트의 요청을 수락하고 응답(SYN-ACK)을 보냄.
        - 서버 state: LISTEN → SYN_RCVD
    3. 클라이언트가 서버의 응답을 확인(ACK)하여 연결이 완료됨.
        - 클라이언트 state: SYN_SENT → ESTABLISHED
        - 서버 state: SYN_RCVD → ESTABLISHED
    - SYN: Synchronize
    - SYN-ACK: Synchronize-Acknowledge
    - ACK: Acknowledge

### 4-way 종료 과정(TCP 연결 종료)은 어떻게 이루어지나요?
- 동작 과정
    1. 클라이언트가 서버로 FIN (Finish)을 보냄
    - **클라이언트 상태**: `ESTABLISHED` → `FIN_WAIT_1`
    - 클라이언트는 데이터를 전송 완료 후, 서버에 연결 종료 요청을 하기 위해 `ESTABLISHED` 상태에서 `FIN_WAIT_1` 상태로 변경합니다.
    
    2. 서버가 클라이언트로 요청을 수락하고 ACK (Acknowledge)를 보냄
    - **서버 상태**: `ESTABLISHED` → `CLOSE_WAIT`
    
    3. 서버가 ACK를 보낸 것을 알려주기 위해 클라이언트로 FIN (Finish)을 보냄
    - **서버 상태**: `CLOSE_WAIT` → `LAST_ACK`
    
    4.  클라이언트가 서버의 FIN 패킷을 확인한 후 연결 종료 요청을 위해 **ACK (Acknowledge)를 보냄**
    - **클라이언트 상태**: `FIN_WAIT_1` → `FIN_WAIT_2`
    - **서버 상태**: `LAST_ACK` → `CLOSED`
    - 서버는 클라이언트의 ACK 패킷을 수신한 후, 연결을 완전히 종료하고 `CLOSED` 상태로 전환
- TCP 연결을 종료할 때 3 way 방식이 아닌 4 way 방식인 이유는 안정적인 연결 종료를 위해서 양방향 통신을 이용하여 클라이언트와 서버 각각이 요청과 응답을 확인하여 종료하기 위함

### 데이터 전송 중 손실이 발생할 때 TCP는 어떻게 처리하나요?
- 송신사 측에서 TCP에서 데이터 스트림을 여러 개의 패킷으로 Sementation을 진행 → 파편화 된 Segmentation을 하나 씩 수신자 측으로 보내게 되는데 이 때 수신자 측에서는 패킷을 정상적으로 수신하면 ACK을 송신자 측에서 전달 함 → 만약에 네트워크 통신 시 패킷이 유실되면 ACK를 받지 못하게 되고 손실이 발생한 것을 송신자 측에서 인지 함 → 즉 손실 된 해당 패킷을 재전송 하여 데이터 손실을 처리(데이터 스트림을 Segmentation한 전체 패킷을 다시 다 보내는 것이 아닌 손실된 패킷만 재전송 함)

### TCP에서 슬라이딩 윈도우 프로토콜의 역할은 무엇인가요?
- 슬라이딩 윈도우 프로토콜이란 송신자 측에서 수신자 측으로 데이터 프레임을 전송할 때 흐름 제어를 하기 위한 프로토콜을 말함.
- 송신자는 수신자에게 윈도우 사이즈 만큼의 패킷을 보내고 수신자 측은 정상정으로 패킷을 수신 받으면 ACK을 비정상적으로 수신을 받으면 NAK을 송신자에게 반환함 → 송신자 측에서 ACK 수신을 받으면 그 다음 패킷을 윈도우 사이즈 만큼 송신하며 NAK을 수신 받으면 기존에 보냈던 패킷에 대해서 재전송을 진행함

### HTTP 상태 코드 200, 301, 404, 500의 차이점을 설명해주세요.
- 200: 클라이언트의 요청에 대해서 서버가 성공적으로 처리했음을 의미
- 301: 클라이언트가 요청한 리소스가 해당 URL에 존재하지 않고 다른 URL에 존재함을 의미
- 404: 클라이언트의 요청에 해당하는 리소스가 존재하지 않음을 의미
- 500: 클라이언트의 요청에 대해서 서버가 처리할 수 없음을 의미
