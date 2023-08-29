const log = console.log;

let video_list = [
     {"TITLE" : "[디자인 패턴] 자바의 싱글톤 패턴 (static)", "WRITE_DATE" : "2022.11.09"}
    ,{"TITLE" : "[Spring Security] GET 로그아웃 처리", "WRITE_DATE" : "2022.11.10"}
    ,{"TITLE" : "[JAVA 8] 분할 가능한 Itortater인 Spliterator 인터페이스", "WRITE_DATE" : "2022.11.11"}
    ,{"TITLE" : "[Spring Security] 스프링 시큐리티를 이용하여 로그인, 회원가입 구현하기", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[Spring Security] 유저별 권한 설정", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[Spring Security] 동시 로그인 제한하기(동시 세션 제어)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[thymeleaf] < > 이스케이프(escape) 해제 (그대로 출력)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[MQ] rabbitMQ", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[디자인패턴] PRG (Post -> Redirect -> Get) pattern 이란?", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[DB] RDB와 NoSQL 차이", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
    ,{"TITLE" : "[디자인 패턴] 자바의 싱글톤 패턴 (static)", "WRITE_DATE" : "2022.11.09"}
   ,{"TITLE" : "[Spring Security] GET 로그아웃 처리", "WRITE_DATE" : "2022.11.10"}
   ,{"TITLE" : "[JAVA 8] 분할 가능한 Itortater인 Spliterator 인터페이스", "WRITE_DATE" : "2022.11.11"}
   ,{"TITLE" : "[Spring Security] 스프링 시큐리티를 이용하여 로그인, 회원가입 구현하기", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[Spring Security] 유저별 권한 설정", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[Spring Security] 동시 로그인 제한하기(동시 세션 제어)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[thymeleaf] < > 이스케이프(escape) 해제 (그대로 출력)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[MQ] rabbitMQ", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[디자인패턴] PRG (Post -> Redirect -> Get) pattern 이란?", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[DB] RDB와 NoSQL 차이", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
   ,{"TITLE" : "[OS] 멀티 프로세스(multi process)와 멀티 스레드(multi thread)", "WRITE_DATE" : "2022.11.13"}
];
video_list = video_list.reverse();

let pageData;

const totalCount = video_list.length;
//총 페이지
const totalPage = Math.ceil(totalCount / 10.0);
let nowPage;

document.addEventListener('DOMContentLoaded', () => {
    // 페이지네이션 세팅
    setPageHtml(1);
    // 데이터 세팅
    setList(1);
})

function setPageHtml(startPage){

    let pageHtml =
       `<li class="page-item">
            <a href="#;" class="page-link" onClick="changePage('first');return false;">First</a>
        </li>
        <li class="page-item">
            <a href="#" class="page-link" onClick="changePage('prev');return false;">Prev</a>
        </li>
        <li class="page-item active">
            <a href="#;" class="page-link" onClick="changePage(${startPage});return false;">${startPage}</a>
        </li>`;
    var startBtnCnt;
    console.log(totalPage, startPage+4)
    if (totalPage >= startPage+4) {
        startBtnCnt = startPage+4;
    } else {
        startBtnCnt = totalPage
    }
    console.log(startBtnCnt)
    for(let i = startPage+1; i <= startBtnCnt; i ++){
        pageHtml +=
            `<li class="page-item">
               <a href="#;" class="page-link" onClick="changePage(${i});return false;">${i}</a>
             </li>`;
    }

    pageHtml +=
       `<li class="page-item">
            <a href="#;" class="page-link" onClick="changePage('next');return false;">Next</a>
        </li>
        <li class="page-item">
            <a href="#;" class="page-link" onClick="changePage('last');return false;">Last</a>
        </li>`;

    document.getElementById("paging").innerHTML = pageHtml;
}

function setList(page){

    // 페이지 당 표시 될 튜플 수
    let pageCount = 15;
    page = page == null ? 1 : page;

    // 표시될 첫 게시글
    let startPage = (page - 1) * pageCount + 1;
    // 표시될 마지막 게시글
    let endPage = startPage + pageCount - 1;
    // if(마지막 게시글 > 총 게시글) 총 게시글을 마지막 게시글로
    endPage = endPage > totalCount ? totalCount : endPage;

    showList(page, pageCount);

    let html = `${page}/${totalPage} 쪽 [총 <strong>${totalCount}</strong>건]`;
    document.getElementById("page_info").innerHTML = html;

    document.getElementById("paging").textContent = null;
    setPageHtml(page)

    // 변경된 페이지 표시
    document.querySelectorAll("#paging li").forEach( (item) => {
        let str = item.querySelector("#paging li a").innerText;
        if(str.includes(page)) {
            item.classList.add("active");
        }else{
            item.classList.remove("active");
        }
    });

}

/** 
 * 해당 페이지 데이터 세팅
 * @param startPage
 * @param endPage
 */
function showList(page, pageCount){
    ajax(page)

    var trList = '';
    for (i = 0; i < pageData.length; i++) {
        trList += toDOM(pageData[i]);
    }
    console.log(trList);
    document.getElementById("html_list").innerHTML = trList;
}


function toDOM(row) {
    var tr = '';
    tr += '<tr className="alert role="alert">';
    tr += '  <td>' + row["A"] + '</td>'; // 기준년도
    tr += '  <td>' + row["D"] + '</td>'; // 학교명
    tr += '  <td>' + row["F"] + '</td>'; // 전형유형명
    tr += '  <td>' + row["G"] + '</td>'; // 전형대분류명
    tr += '  <td>' + row["H"] + '</td>'; // 전형중분류명
    tr += '  <td>' + row["I"] + '</td>'; // 전형소분류명
    tr += '</tr>';
    return tr;
}

function ajax(page) {
    var searchText = document.getElementById("html_list").value;
    console.log(searchText)
    let data = {
        searchText: searchText,
        page: page
    }
    // jQuery를 이용한 AJAX 요청
    $.ajax({
        url: '/universityInfo',  // 요청할 URL
        type: 'post',      // 요청 타입 (GET, POST 등)
        dataType: 'json', // 응답 데이터 타입 (JSON, XML 등)
        data: data,
        success: function(response) {
            // 서버 응답 성공 시 실행되는 콜백 함수
            // response 변수에 서버에서 받은 데이터가 담겨 있음
            // 원하는 작업 수행
            console.log(response["pageData"])
            console.log(response["totalCount"])

            pageData = response['pageData']
            totalCount = response['totalCount']
        },
        error: function(xhr, status, error) {
            // 서버 요청 실패 시 실행되는 콜백 함수
            // 오류 처리 등을 수행
        }
    });
}


/**
 * 페이지 클릭 이벤트
 * @param page
 * @returns
 */
function changePage(page){
    log("page ==> " + page);
    
    // 현재 페이지
    nowPage = parseInt(document.querySelector("#paging .active a").innerText);
    log("nowPage --> " + nowPage);

    if(page === "first"){
        page = 1;
    }else if(page === "prev"){
        page = (nowPage - 1) < 1 ? nowPage : (nowPage - 1);
    }else if(page === "next"){
        page = (nowPage + 1) > totalPage ? totalPage : (nowPage + 1);
    }else if(page === "last"){
        page = totalPage;
    }

    if (page)

    if(nowPage != page)
        console.log(page)
        setList(page);
}