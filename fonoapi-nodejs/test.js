var fonoapi = require('./fonoapi.node.js');

function printHandler(queryString, data) {
	if (data.hasOwnProperty('length')) {
		data.forEach(function (device) {
			console.log(device.DeviceName);
		});
        console.log(' ');
	} else if (data.hasOwnProperty('message')) {
		console.log(data.message);
	} else {
		console.log('Invalid data: ' + JSON.stringify(data));
	}
}

fonoapi.token = 'bb48887db376bf9d8c1b0e20ee347d9a770c811372512c8a';
fonoapi.printDevices(' galaxy s5');
fonoapi.printDevices('galaxy s5');
fonoapi.getDevicesWithBrand(' galaxy s7', 'samsung', printHandler);

fonoapi.printLatest();
