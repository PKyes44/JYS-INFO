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