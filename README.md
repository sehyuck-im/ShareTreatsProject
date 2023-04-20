# ShareTreats
 ShareTreatsProject for Application
 
# 개발 환경
Java version 11 <br>
Spring Boot version 2.6.3

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
 
