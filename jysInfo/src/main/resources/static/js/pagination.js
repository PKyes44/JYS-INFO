const log = console.log;
let pageData;
let totalCount;
//총 페이지
let totalPage;
let nowPage;
let page;

document.addEventListener('DOMContentLoaded', () => {
    // 데이터 세팅
    ajax(1)
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
    console.log("totalPage : " + totalPage + " startPage+4 : " + startPage+4)
    if (totalPage >= startPage+4) {
        startBtnCnt = startPage+4;
    } else {
        startBtnCnt = totalPage
    }
    console.log("startBtnCnt : " + startBtnCnt)
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

    let html = `${page}/${totalPage} 쪽 [총 <strong>${totalCount}</strong>건]`;
    document.getElementById("page_info").innerHTML = html;

    console.log("showList ready");
    showList(page, pageCount);
    console.log("showList success");

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

function showList(page, pageCount){
    var trList = '';

    var index;
    if (page == 1) {
        index = 1;
    } else {
        index = (pageCount * (page - 1)) + 1
    }
    for (i = 0; i < pageCount; i++) {
        var seq = index + i;
        trList += toDOM(seq, pageData[i]);
    }
    console.log(trList);
    document.getElementById("html_list").innerHTML = trList;
}


function toDOM(seq, row) {
    var tr = '';
    tr += '<tr className="alert role="alert">';
    tr += '  <th scope="row">' + seq + '</td>'; // 인덱스
    tr += '  <td>' + row["baseYear"] + '</td>'; // 기준년도
    tr += '  <td>' + row["establishSeparate"] + '</td>'; // 설립구분명
    tr += '  <td>' + row["schoolName"] + '</td>'; // 학교명
    tr += '  <td>' + row["admissionType"] + '</td>'; // 전형유형명
    tr += '  <td>' + row["admissionMainName"] + '</td>'; // 전형대분류명
    tr += '  <td>' + row["admissionMediumName"] + '</td>'; // 전형중분류명
    tr += '  <td>' + row["admissionMediumName"] + '</td>'; // 전형소분류명
    tr += '</tr>';
    return tr;
}

function ajax() {
    var searchText = document.getElementById("searchInput").value;
    console.log("searchText : " + searchText)
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
        async: true, //비동기 여부
        timeout: 10000, //타임 아웃 설정 (1000 = 1초)
        success: function(response) {
            // 서버 응답 성공 시 실행되는 콜백 함수
            // response 변수에 서버에서 받은 데이터가 담겨 있음
            // 원하는 작업 수행
            console.log(response["tableData"])
            console.log("totalCount : " + response["dataCount"])

            pageData = response['tableData']
            totalCount = response['dataCount']
            totalPage = Math.ceil(totalCount / 10.0)
            setList(page)
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

    if(nowPage != page)
        console.log("page : " + page)
        ajax(page)
}