package money;

import java.util.ArrayList;
import java.util.Scanner;

public class BankManager {

	public static void main(String[] args) throws Exception {
		BankDAO dao = new BankDAO();
		Scanner sc = new Scanner(System.in);

		// 사용자로 부터 입력 받은 정보를 저장할 변수(아이디, 이름, 전화번호, 나이, 입력값)
		String id, name, tel;
		int age, input;

		System.out.println("은행 회원 관리 페이지 입니다.");
		while (true) {
			System.out.println("======================================================================");
			System.out.println("1. 회원 정보 삽입, 2. 회원 정보 수정, 3. 회원 탈퇴, 4. 회원 검색, 5. 회원 전체 검색, 6. 종료");
			System.out.println("======================================================================");
			System.out.print("선택: ");
			input = sc.nextInt();

			// 회원 정보 삽입
			if (input == 1) {
				// 사용자로부터 회원 정보를 입력 받음
				System.out.print("아이디 입력: ");
				id = sc.next();
				System.out.print("이름 입력: ");
				name = sc.next();
				System.out.print("나이 입력: ");
				age = sc.nextInt();
				System.out.print("전화번호 입력: ");
				tel = sc.next();

				dao.insert(id, name, age, tel);

				// 회원 정보 수정
			} else if (input == 2) {
				System.out.print("수정할 회원 아이디 입력: ");
				id = sc.next();
				System.out.print("수정할 전화번호 입력: ");
				tel = sc.next();

				dao.update(id, tel);

				// 회원 탈퇴
			} else if (input == 3) {
				System.out.print("탈퇴할 회원 아이디 입력: ");
				id = sc.next();

				dao.delete(id);

				// 회원 검색
			} else if (input == 4) {
				System.out.print("검색할 회원 아이디 입력: ");
				id = sc.next();

				BankDTO result = dao.select(id);
				System.out.println(result);

				// 회원 전체 리스트 출력
			} else if (input == 5) {
				ArrayList<BankDTO> result = dao.selectAll();

				for (int i = 0; i < result.size(); i++) {
					System.out.println(result.get(i));
				}

				// 프로그램 종료
			} else if (input == 6){
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			System.out.println();
		}

	}

}
