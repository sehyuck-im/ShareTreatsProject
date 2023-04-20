# ShareTreats
 ShareTreatsProject for Application
 
# 개발 환경
### Java version 11 <br>
### Spring Boot version 2.6.3

# 구현 목록

1. 상품 교환 서비스
   * 상품 코드 사용 여부 조회
   * 사용법 안내문 출력
   * 상품 교환으로 상품 코드 사용
   * 입력 규정에 어긋날 경우 사용법 안내문 출력
   
   
2. 상품 뽑기 서비스
   
3. 회사 조직(부서) 인원수 파악 서비스

# 구현 조건

1. 상품 교환 서비스
 * test 디렉토리안 ExchangeControllerTest class에 존재하는 runTest()로 작동합니다.
 * 상품 교환 서비스의 데이터인 상품코드는 20개가 준비 됩니다.
 * 10개는 이미 사용한 상품코드입니다. (List index 홀수)
 * SHARETREATS는 고객에게 CHECK, HELP, CLAIM 명령어를 사용할 수 있게 합니다.
   <br>각 키워드는 CHECK(상품 교환여부 확인), HELP(사용법 안내), CLAIM(상품 교환) 을 의미합니다.
 * 프로그램 기동시 사용법과 list를 console에 출력
   <br>
   코드 : 숫자9자리, 사용 여부 : boolean, 사용처 : 영문대소문자 6자리 또는 none
   <br>
   입력 양식<br>
   사용 여부 확인 : CHECK [상품코드] <br>
   도움말 : HELP <br>
   사용 처리 : CLAIM [상점코드] [상품코드] <br>
   프로그램 종료 : EXIT <br>
 * 도움말 HELP 입력시 도움말을 console에 출력합니다.
   <br>도움말
   <br>사용 여부 확인 : CHECK [상품코드]
   <br>사용 처리 : CLAIM [상점코드] [상품코드]
   <br>CHECK, CLAIM은 영문대문자로 입력하셔야합니다.
   <br>입력시 예시에있는 [ ]대괄호는 제외하고 입력해주세요.
   <br>상점코드, 상품코드 입력시 공백(스페이스바) 제외하고 입력해주세요
   <br>상점코드는 영문대소문자 6자리, 상품코드는 0~9 자연수 9자리입니다.
   <br>프로그램 종료 : EXIT
   
# 예외 처리

1. 상품 교환 서비스
  * BufferedReader로 입력 오류 IOException 발생시 console에 "입력 오류가 발생하였습니다. 다시 시도해주세요." 출력
  * BufferedReader로 받은 문자열을 StringTokenizer로 분리
  * StringTokenizer[0]를 command로 인식하여 CHECK, HELP, CLAIM, EXIT command가 아닌 경우 사용법을 console에 출력
  * 30글자 넘게 입력시 "30글자 이상 입력하셨습니다. 입력은 30글자 이하로 부탁드립니다." console 출력
  * input 입력시 공백 혹은 개행문자만 입력시 사용법 console에 출
  * CHECK 상품코드 조회할 때 먼저 isValidGoodsCode 메소드를 사용해서 list에 객체가 존재하는지 확인
    - 객체가 없는 경우 "존재하지 않는 코드입니다" 출력
    - 객체가 존재한다면 입력한 코드와 사용 여부 판별 후 결과물 출력
  * CLAIM 사용처리가 입력된 경우 StringTokenizer의 count로 입력이 제대로 되었는지 판단
    - count가 2인 경우 상점코드를 먼저 영문대소문자 6글자인지 판별
    - 유효한 상점코드인 경우 상품코드 사용 여부 확인
      - 사용가능한 코드라면 list에서 객체에 상품코드와 사용여부 변경하고 list 반환
      - 이미 사용한 상품코드인 경우 상품코드와 사용된 상점코드 출력
    - 유효한 상점코드가 아닐경우 CLAIM 입력 예시와 사용자가 입력한 입력값 출력
    - count가 다른 숫자일 경우 "사용 처리 입력이 잘못되었습니다."와 사용자가 입력한 입력값 출력
  
