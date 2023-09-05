google.charts.load('current', {'packages':['bar']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
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

                pageData = response['tableData'];
                totalCount = response['dataCount'];
                pageSize = response['pageSize'];
                totalPage = Math.ceil(totalCount / pageSize);
                setList(page);
            },
            error: function(xhr, status, error) {
                // 서버 요청 실패 시 실행되는 콜백 함수
                // 오류 처리 등을 수행
            }
        });

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