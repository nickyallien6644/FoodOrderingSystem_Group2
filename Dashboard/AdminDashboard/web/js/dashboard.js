var optionsProfileVisitWeek = {
	annotations: {
		position: 'back'
	},
	dataLabels: {
		enabled:false
	},
	chart: {
		type: 'bar',
		height: 300
	},
	fill: {
		opacity:1
	},
	plotOptions: {
	},
	series: [{
		name: 'Orders',
		data: [60,70,65,45,56,35,30]
	}],
	colors: '#435ebe',
	xaxis: {
		categories: ["2021-02-13","2021-02-14","2021-02-15","2021-02-16", "2021-02-17","2021-02-18","2021-02-19"],
	},
}

var optionsProfileVisitMonth = {
	annotations: {
		position: 'back'
	},
	dataLabels: {
		enabled:false
	},
	chart: {
		type: 'bar',
		height: 300
	},
	fill: {
		opacity:1
	},
	plotOptions: {
	},
	series: [{
		name: 'Orders',
		data: [53,20,30,20,20,20,30,30,10,20,30,60]
	}],
	colors: '#435ebe',
	xaxis: {
		categories: ["Jan","Feb","Mar","Apr","May","Jun","Jul", "Aug","Sep","Oct","Nov","Dec"],
	},
}

var optionsProfileVisitYear = {
	annotations: {
		position: 'back'
	},
	dataLabels: {
		enabled:false
	},
	chart: {
		type: 'bar',
		height: 300
	},
	fill: {
		opacity:1
	},
	plotOptions: {
	},
	series: [{
		name: 'Orders',
		data: [1500,2300,3000,3100,3200]
	}],
	colors: '#435ebe',
	xaxis: {
		categories: ["2017","2018","2019","2020","2021"],
	},
}

var optionsVisitorsProfile  = {
	series: [30, 20, 50],
	labels: ['Circle k - 59 Nguyen Van Cu', 'Circle k - 57 - 59 Ngo Van So', 'Circle k - N.17 30/04'],
	colors: ['#435ebe','#55c6e8', '#00a8ff'],
	chart: {
		type: 'donut',
		width: '100%',
		height:'350px'
	},
	legend: {
		position: 'bottom'
	},
	plotOptions: {
		pie: {
			donut: {
				size: '30%'
			}
		}
	}
}

var optionsEurope = {
	series: [{
		name: 'Meal portion',
		data: [10, 12, 6, 1, 0, 5, 10, 30, 25, 20, 25, 36, 50]
	}],
	chart: {
		height: 80,
		type: 'area',
		toolbar: {
			show:false,
		},
	},
	colors: ['#5350e9'],
	stroke: {
		width: 2,
	},
	grid: {
		show:false,
	},
	dataLabels: {
		enabled: false
	},
	xaxis: {
		type: 'datetime',
		categories: ["2021-02-19T00:30:00.000Z", "2021-02-19T01:30:00.000Z", "2021-02-19T02:30:00.000Z", "2021-02-19T03:30:00.000Z", "2021-02-19T04:30:00.000Z", "2021-02-19T05:30:00.000Z", "2021-02-19T06:30:00.000Z", "2021-02-19T07:30:00.000Z", "2021-02-19T08:30:00.000Z", "2021-02-19T09:30:00.000Z", "2021-02-19T10:30:00.000Z", "2021-02-19T11:30:00.000Z", "2021-02-19T12:30:00.000Z"],
		axisBorder: {
			show:false
		},
		axisTicks: {
			show:false
		},
		labels: {
			show:false,
		}
	},
	show:false,
	yaxis: {
		labels: {
			show:false,
		},
	},
	tooltip: {
		x: {
			format: 'dd/MM/yy HH:mm'
		},
	},
};

var optionsAmerica = {
	series: [{
		name: 'series1',
		data: [20, 15, 10, 5, 10]
	}],
	chart: {
		height: 80,
		type: 'area',
		toolbar: {
			show:false,
		},
	},
	colors: ['#008b75'],
	stroke: {
		width: 2,
	},
	grid: {
		show:false,
	},
	dataLabels: {
		enabled: false
	},
	xaxis: {
		type: 'datetime',
		categories: ["2021-02-19T13:30:00.000Z", "2021-02-19T14:30:00.000Z", "2021-02-19T15:30:00.000Z", "2021-02-19T16:30:00.000Z", "2021-02-19T17:30:00.000Z"],
		axisBorder: {
			show:false
		},
		axisTicks: {
			show:false
		},
		labels: {
			show:false,
		}
	},
	show:false,
	yaxis: {
		labels: {
			show:false,
		},
	},
	tooltip: {
		x: {
			format: 'dd/MM/yy HH:mm'
		},
	},
}
var optionsIndonesia = {
	series: [{
		name: 'series1',
		data: [20, 15, 25, 5, 13, 17]
	}],
	chart: {
		height: 80,
		type: 'area',
		toolbar: {
			show:false,
		},
	},
	colors: ['#dc3545'],
	stroke: {
		width: 2,
	},
	grid: {
		show:false,
	},
	dataLabels: {
		enabled: false
	},
	xaxis: {
		type: 'datetime',
		categories: ["2021-02-19T18:30:00.000Z", "2021-02-19T19:30:00.000Z", "2021-02-19T20:30:00.000Z", "2021-02-19T21:30:00.000Z", "2021-02-19T22:30:00.000Z", "2021-02-19T23:30:00.000Z"],
		axisBorder: {
			show:false
		},
		axisTicks: {
			show:false
		},
		labels: {
			show:false,
		}
	},
	show:false,
	yaxis: {
		labels: {
			show:false,
		},
	},
	tooltip: {
		x: {
			format: 'dd/MM/yy HH:mm'
		},
	},
	
}



var chartProfileVisitWeek = new ApexCharts(document.querySelector("#chart-profile-visit-Week"), optionsProfileVisitWeek);
var chartProfileVisitMonth = new ApexCharts(document.querySelector("#chart-profile-visit-Month"), optionsProfileVisitMonth);
var chartProfileVisitYear = new ApexCharts(document.querySelector("#chart-profile-visit-Year"), optionsProfileVisitYear);

var chartVisitorsProfile = new ApexCharts(document.querySelector("#chart-visitors-profile"), optionsVisitorsProfile);
var chartEurope = new ApexCharts(document.querySelector("#chart-europe"), optionsEurope);
var chartAmerica = new ApexCharts(document.querySelector("#chart-america"), optionsAmerica);
var chartIndonesia = new ApexCharts(document.querySelector("#chart-indonesia"), optionsIndonesia);

chartIndonesia.render();
chartAmerica.render();
chartEurope.render();
chartProfileVisitWeek.render();
chartProfileVisitMonth.render();
chartProfileVisitYear.render();
chartVisitorsProfile.render();