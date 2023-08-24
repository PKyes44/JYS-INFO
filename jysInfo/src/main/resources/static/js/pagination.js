const showPageCnt = 5; // 화면에 보일 페이지 번호 개수

$(function() {
  // 데이터 조회
  searchPosts(1);

  // floatThead - 헤더 고정
  const $table = $('#app>table');
//  $table.floatThead({
//    position: 'fixed',
//    scrollContainer: true
//  });

  // 페이지당 건수(10, 30, 50)가 변경되면 재조회
  $('#countPerPage').change(function() {
    searchPosts(1);
  });

  // 페이지 번호 클릭
  $(document).on('click', 'div.paging>div>div.pages>span', function() {
    if (!$(this).hasClass('active')) {
      $(this).parent().find('span.active').removeClass('active');
      $(this).addClass('active');

      searchPosts(Number($(this).text()));
    }
  });

  // 페이징 Icon(<<, <, >, >>) 클릭
  $(document).on('click', 'div.paging>div>i', function() {
    const totalCnt = parseInt($('span.total').text());
    const countPerPage = $('#countPerPage').val() || 10;
    const totalPage = Math.ceil(totalCnt / countPerPage);

    //console.log(totalCnt, countPerPage, totalPage);
    //console.log($(this).attr('id'));

    const id = $(this).attr('id');

    // <<
    if (id == 'first_page') {
      searchPosts(1);
    } else if (id == 'prev_page') {
      // <
      let arrPages = [];
      $('div.paging>div>div.pages>span').each(function(idx, item) {
        arrPages.push(Number($(this).text()));
      });

      const prevPage = _.min(arrPages) - showPageCnt;
      searchPosts(prevPage);
    } else if (id == 'next_page') {
      // >
      let arrPages = [];
      $('div.paging>div>div.pages>span').each(function(idx, item) {
        arrPages.push(Number($(this).text()));
      });

      const nextPage = _.max(arrPages) + 1;
      searchPosts(nextPage);
    } else if (id == 'last_page') {
      // >>
      const lastPage = totalPage;
      searchPosts(lastPage);
    }
  });
});
    function toDOM(row) {
        var tr = '';
        tr += '<tr>';
        tr += '  <td>' + row["A"] + '</td>';
        tr += '  <td>' + row["D"] + '</td>';
        tr += '  <td>' + row["F"] + '</td>';
        tr += '  <td>' + row["G"] + '</td>';
        tr += '  <td>' + row["H"] + '</td>';
        tr += '  <td>' + row["I"] + '</td>';
        tr += '</tr>';
        return tr;
      }
/**
 * 페이지별 데이터를 조회합니다.
 * @param {int} pageNum - Page Number
 */
function searchPosts(pageNum) {
  const countPerPage = $('#countPerPage').val() || 10;
  const start = (pageNum - 1) * countPerPage;
  //console.log(countPerPage, start);

//  $.blockUI();

  $.ajax({
      url: '/universityInfo',  // 요청할 URL
      type: 'post',      // 요청 타입 (GET, POST 등)
      dataType: 'json', // 응답 데이터 타입 (JSON, XML 등)
      success: function(response) {
          // 서버 응답 성공 시 실행되는 콜백 함수
          // response 변수에 서버에서 받은 데이터가 담겨 있음
          // 원하는 작업 수행
          console.log(response["pageData"])

          var pageData = response['pageData']
          var trList = '';
          console.log(pageData)
          for (i = 0; i < pageData.length; i++) {
              trList += toDOM(pageData[i]);
          }
          $('table>tbody').html(trList);
            // 맨 처음에만 total값 세팅
            if (pageNum == 1) {
              $('span.total').text((pageData.total || 0));
            }
          // 페이징 정보 세팅
          setPaging(pageNum);
//                  $.unblockUI
      },
      error: function(xhr, status, error) {
          // 서버 요청 실패 시 실행되는 콜백 함수
          // 오류 처리 등을 수행
      }
  });
}

/**
 * 페이징 정보를 세팅합니다.
 * @param {int} pageNum - Page Number
 */
function setPaging(pageNum) {
  const totalCnt = parseInt($('span.total').text());
  const countPerPage = $('#countPerPage').val() || 10;

  const currentPage = pageNum;
  const totalPage = Math.ceil(totalCnt / countPerPage);
  //console.log(currentPage, totalPage);

  showAllIcon();

  if (currentPage <= showPageCnt) {
    $('#first_page').hide();
    $('#prev_page').hide();
  }
  if (
    totalPage <= showPageCnt ||
    Math.ceil(currentPage / showPageCnt) * showPageCnt + 1 > totalPage
  ) {
    $('#next_page').hide();
    $('#last_page').hide();
  }

  let start = Math.floor((currentPage - 1) / showPageCnt) * showPageCnt + 1;
  let sPagesHtml = '';
  for (const end = start + showPageCnt; start < end && start <= totalPage; start++) {
    sPagesHtml += '<span class="' + (start == currentPage ? 'active' : '') + '">' + start + '</span>';
  }
  $('div.paging>div>div.pages').html(sPagesHtml);
}

/**
 * Icon(<<, <, >, >>)을 모두 보여줍니다.
 */
function showAllIcon() {
  $('#first_page').show();
  $('#prev_page').show();
  $('#next_page').show();
  $('#last_page').show();
}
