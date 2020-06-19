$(function() {
    $('#simplebtn').on('click', function() {
        $.ajax({
            type: 'GET',
            url: 'http://api.timezonedb.com/v2.1/list-time-zone?key=J3SYS1NNO9NW&format=json',
            success: function(data, status, xhr) {

                var sample = data.zones;

                sample.sort(function(a, b) { return a.gmtOffset - b.gmtOffset });

                for (let i = 0; i < sample.length; i++) {

                    // let sample = Math.floor(data.zones[0].timestamp - data.zones[0].gmtOffset) / 3600

                    let hour = Math.floor((sample[i].gmtOffset) % (3600 * 24) / 3600);
                    var minute = Math.abs(sample[i].gmtOffset % 3600 / 60);

                    console.log(hour + ":" + minute);
                    // Math.floor(d / 3600)

                    // $('.tabcont').append('<tr><td>' + data.zones[i].countryCode + '</td><td>' + data.zones[i].countryName + '</td><td>' + data.zones[i].zoneName + '</td><td>' + data.zones[i].gmtOffset + '</td><td>' + data.zones[i].timestamp + '</td></tr>');

                    $('.tabcont').append('<tr><td> GMT ( ' + hour + ":" + minute + ' ) ' + sample[i].zoneName + '</td></tr>');
                }

                // $('#test').

            },
            dataType: 'json'
        });
    });
});