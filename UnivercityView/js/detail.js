let pageData;
function viewDetail(id) {
    console.log("viewDetail ID : " + id);
    let data = {
        dataId: id
    };
    // jQuery를 이용한 AJAX 요청
    $.ajax({
        url: '/universityInfo/deatil',  // 요청할 URL
        type: 'post',      // 요청 타입 (GET, POST 등)
        dataType: 'json', // 응답 데이터 타입 (JSON, XML 등)
        data: data,
        async: true, //비동기 여부
        timeout: 10000, //타임 아웃 설정 (1000 = 1초)
        success: function(response) {
            pageData = response['pageDetailData'];
        },
        error: function(xhr, status, error) {
            // 서버 요청 실패 시 실행되는 콜백 함수
            // 오류 처리 등을 수행
        }
    });
}