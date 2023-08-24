const log = console.log;
let pageData;
let totalCount;
let totalPage;

$.ajax({
    url: '/universityInfo',  // 요청할 URL
    type: 'post',      // 요청 타입 (GET, POST 등)
    dataType: 'json', // 응답 데이터 타입 (JSON, XML 등)
    success: function(response) {
        // 서버 응답 성공 시 실행되는 콜백 함수
        // response 변수에 서버에서 받은 데이터가 담겨 있음
        // 원하는 작업 수행
        console.log(response["pageData"])

        pageData = response['pageData']


        totalCount = pageData.length;
        //총 페이지
        totalPage = Math.ceil(totalCount / 10.0);

        // 페이지네이션 세팅
        setPageHtml();
        // 데이터 세팅
        setList();
//        document.addEventListener('DOMContentLoaded', () => {
//
//        })
    },
    error: function(xhr, status, error) {
        // 서버 요청 실패 시 실행되는 콜백 함수
        // 오류 처리 등을 수행
    }
});


function setPageHtml(){

    let pageHtml =
       `<li class="page-item">
            <a href="#;" class="page-link" onClick="changePage('first');return false;">First</a>
        </li>
        <li class="page-item">
            <a href="#" class="page-link" onClick="changePage('prev');return false;">Prev</a>
        </li>
        <li class="page-item active">
            <a href="#;" class="page-link" onClick="changePage(1);return false;">1</a>
        </li>`;

    for(let i = 2; i <= totalPage; i ++){
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
    let pageCount = 10;
    page = page == null ? 1 : page;

    // 표시될 첫 게시글
    let startPage = (page - 1) * pageCount + 1;
    // 표시될 마지막 게시글
    let endPage = startPage + pageCount - 1;
    // if(마지막 게시글 > 총 게시글) 총 게시글을 마지막 게시글로
    endPage = endPage > totalCount ? totalCount : endPage;

    showList(startPage, endPage);

    let html = `${page}/${totalPage} 쪽 [총 <strong>${totalCount}</strong>건]`;
    document.getElementById("page_info").innerHTML = html;

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
function showList(startPage, endPage){

    let html = "";

    for(let i = (startPage - 1) ; i < endPage; i++) {
        row = pageData[i];

        html += `<tr className="alert" role="alert">
                    <th scope="row">${row["A"]}</th>
                    <td>${row["D"]}</td>
                    <td>${row["F"]}</td>
                    <td>${row["G"]}</td>
                    <td>${row["H"]}</td>
                    <td>${row["I"]}</td>
                  </tr>`;

    }

    document.getElementById("html_list").innerHTML = html;
}


/**
 * 페이지 클릭 이벤트
 * @param page
 * @returns
 */
function changePage(page){
    log("page ==> " + page);

    // 현재 페이지
    let nowPage = parseInt(document.querySelector("#paging .active a").innerText);
    log("nowPage --> " + nowPage);

    if(page === "first"){
        page = "1";
    }else if(page === "prev"){
        page = (nowPage - 1) < 1 ? nowPage : (nowPage - 1);
    }else if(page === "next"){
        page = (nowPage + 1) > totalPage ? totalPage : (nowPage + 1);
    }else if(page === "last"){
        page = totalPage;
    }

    if(nowPage != page)
        setList(page);
}