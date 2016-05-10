var httpreq = require('httpreq');

function printHandler(queryString, data) {
	console.log('--- \'' + queryString + '\'');

	if (data.hasOwnProperty('length')) {
		console.log('- Found ' + data.length);

		data.forEach(function (device) {
			console.log(device.DeviceName);
		});
	} else if (data.hasOwnProperty('message')) {
		console.log(data.message);
	} else {
		console.log('Invalid data: ' + JSON.stringify(data));
	}

	console.log('---');
}

function getDevices(queryString, callback) {
	var url = 'https://fonoapi.freshpixl.com/v1/getdevice';
	var options = {
		parameters: {device: queryString, token: module.exports.token},
		timeout: 2900
	};

	httpreq.post(url, options, function (err, res) {
		if (err) {
			console.log(err);
		} else {
			var data = JSON.parse(res.body);
			callback(queryString, data);
		}
	});
}

function printDevices(queryString) {
	getDevices(queryString, printHandler);
}

module.exports = {
	token: '',
	getDevices: getDevices,
	printDevices: printDevices,
	printHandler: printHandler
};
