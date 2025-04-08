-- JSP 프로젝트(회원 관리 프로젝트) --
/*
[ 1. Member 테이블 설계 ]
-- id, pwd, username, nickname, age, birthday, job, email, phone, address, reg_date
-> 제약조건명도 함께 설정
1. 필드(컬럼) 구성 - 11개 컬럼으로 구성
- id: varchar2(20), primary key, 아이디
- pwd: varchar2(20), not null, 비밀번호
- username: varchar2(18), not null, 회원명 -> 오라클에서 주의할 점: 한글 1글자는 3바이트 
- nickname: varchar2(18), not null, 별명
- age: number(3), not null, 나이 
- birthday: date, not null, 생년월일
- job: varchar2(30), not null, 직업
- email: varchar2(40), not null, 이메일
- phone: varchar2(13), not null, 휴대폰 번호
- address: varchar2(150), not null, 주소 -> 오라클에서 주의할 점: 한글 1글자는 3바이트
- reg_date: date, default, sysdate, 가입일
*/

-- 물리 테이블 생성
create table member (
id varchar2(20) constraint member_id_pk primary key,
pwd varchar2(20) constraint member_pwd_nn not null,
username varchar2(18) constraint member_username_nn not null,
nickname varchar2(18) constraint member_nickname_nn not null,
age number(3) constraint memeber_age_nn not null,
birthday date constraint member_birthday_nn not null,
job varchar2(30) constraint member_job_nn not null,
email varchar2(40) constraint memeber_email_nn not null,
phone varchar2(13) constraint member_phone_nn not null,
address varchar2(150) constraint memver_address_nn not null,
reg_date date default sysdate
);

-- 테이블 제거
drop table member;

desc member;
select * from member;
select * from user_tables;
select * from user_constraints where table_name = 'MEMBER';

-- 데이터 추가
insert into member values(
'aaaa',
'1234',
'김연아',
'피겨퀸',
'34',
to_date('1990/09/05', 'yyyy/mm/dd'),
'피겨선수',
'aaaa@korea.com', 
'010-1004-1004',
'경기도 일산시 중구 일산동 일산아파트 106동 707호',
sysdate
);

insert into member values(
'bbbb',
'1234',
'박찬호',
'여름사나이',
'52',
to_date('1973/07/28', 'yyyy/mm/dd'),
'야구선수',
'bbbb@korea.com',
'010-1111-1111',
'경기도 부천시 남구 부천동 부천아파트 303동 1505호',
sysdate
);

insert into member values(
'cccc',
'1234',
'신유빈',
'탁구공주',
'20',
to_date('2004/07/05', 'yyyy/mm/dd'),
'탁구선수',
'cccc@korea.com',
'010-3333-3333',
'경기도 일산시 중구 일산동 일산아파트 505동 606호',
sysdate
);

insert into member values(
'dddd',
'1234',
'안시현',
'양궁퀸',
'21',
to_date('2003/06/13', 'yyyy/mm/dd'),
'양궁선수',
'dddd@korea.com',
'010-4444-4444',
'경기도 수원시 북구 매산동 매산아파트 404동 405호',
sysdate
);

insert into member values(
'eeee',
'1234',
'박지성',
'맨유맨',
'43',
to_date('1981/02/25', 'yyyy/mm/dd'),
'축구선수',
'eeee@korea.com',
'010-5555-5555',
'경기도 구리시 동구 구리동 구리아파트 707동 808호',
sysdate
);

select * from member;
commit;

delete from member where id = 'eeee';
commit;

-- 관리자 테이블 생성
create table manager (
m_id varchar2(20) primary key,
m_pwd varchar2(20) not null
);

-- 관리자 추가
insert into manager values('admin', '123456');
commit;

select * from manager;

/*
[ 2. Board 테이블 설계 ]
- 게시글을 등록, 수정, 삭제 조회할 수 있는 게시판
- 10개의 필드 구성
- num(글번호), writer(작성자), subject(글제목), content(글내용), reg_date(등록일),
- readcount(조회수), recommcount(추천수)
- ref(원글번호), re_step(댓글 순서), re_level(댓글 단계)
- 댓글관련 컬럼: ref, re_step, re_level
- 글번호는 자동으로 1씩 증가하는 번호 -> 시퀀스 사용, PK로 구성
- 등록일은 default 값 -> 오늘 날짜
- 작성자는 회원의 아이디 -> FK로 구성, 회원 테이블에서 해당 아이디가 삭제되면 게시판 테이블의 글도 함께 삭제
*/
-- board 테이블 생성
create table board (
num number(11),
writer varchar2(20) constraint board_writer_nn not null,
subject varchar2(100) constraint board_subject_nn not null, 
content varchar2(1000) constraint board_content_nn not null,
reg_date date default sysdate,
readcount number(11) default 0,
recommcount number(11) default 0,
ref number(11) default 0,
re_step number(4) default 0,
re_level number(4) default 0,
constraint board_num_pk primary key(num),
constraint board_writer_fk foreign key(writer) references member(id) on delete cascade
);

-- 테이블 제거
drop table board;

-- 테이블 확인
desc board;
select * from user_constraints where table_name = 'BOARD';
select * from user_tab_columns where table_name = 'BOARD';

-- 테이블 삭제
drop table board;

-- board 테이블의 num에서 사용할 시퀀스 생성
create sequence board_seq start with 1 increment by 1;

-- 시퀀스 확인
select * from user_sequences;

-- 시퀀스 삭제
drop sequence board_seq;

-- 데이터 추가
insert into board(num, writer, subject, content, ref) values(
board_seq.nextval, 'aaaa', '매서운 한파', '당분간 매서운 한파가 계속됩니다.', board_seq.currval
);
insert into board(num, writer, subject, content, ref) values(
board_seq.nextval, 'aaaa', '중국산 AI', '중국에서 AI 딥시크를 개발했습니다.', board_seq.currval
);
insert into board(num, writer, subject, content, ref) values(
board_seq.nextval, 'aaaa', 'MBC 기상캐스터', '기상캐스터 오요안나씨의 직장내 괴롭힘.', board_seq.currval
);
insert into board(num, writer, subject, content, ref) values(
board_seq.nextval, 'bbbb', '트럼프 관세', '미국에서 트럼프가 관세로 전세계를 압박하고 있습니다.', board_seq.currval
);
insert into board(num, writer, subject, content, ref) values(
board_seq.nextval, 'bbbb', '중국 관세 협상', '트럼프는 중국에 관세로 협박하고 있습니다.', board_seq.currval
);

-- 데이터 확인
select * from board order by num desc;
commit;

-- 데이터 삭제
truncate table board; 

-- 현재 시퀀스 확인
select board_seq.nextval from dual;

select board_seq.currval from dual;

--
delete from board where num > 5;
commit;

-- 모든 데이터 삭제
truncate table board;

-- board 테이블에 페이징 처리를 위한 더미 데이터 추가
-- 프로시저를 사용
create or replace procedure p_paging
is
begin
    for i in 1..255 loop
        insert into board(num, writer, subject, content, ref) values(
        board_seq.nextval,
        'aaaa',
        concat('게시판 테스트', i),
        concat('게시판에서 페이징을 테스트하고 있습니다.', i),
        board_seq.currval
        );
    end loop;
end;
/

execute p_paging;
commit;

-- 10건씩을 확인하는 방법
select * from (
    select b.*, row_number() over(order by num desc) rnum from board b
) where rnum between 1 and 10;

select * from board order by num desc;




