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

google.charts.load('current', {'packages':['bar']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
var data = google.visualization.arrayToDataTable([
['연도', '수시등록률(%)', '정시등록률(%)', '추가등록률(%)', '최종등록률(%)'],
['2014', 1000, 400, 200, 20],
['2015', 1170, 460, 250, 20],
['2016', 660, 1120, 300, 20],
['2017', 1030, 540, 350, 20]
]);

var options = {
chart: {
title: '연도별 입결 그래프',
width: '100%'
}
};

var mq = window.matchMedia( "(max-width: 1024.98px)" );
if (mq.matches) {
var options = {
    legend: {
    position: 'none'
    }
}   
}

var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

chart.draw(data, google.charts.Bar.convertOptions(options));
}