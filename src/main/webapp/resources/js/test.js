$(function(){	
	var app = angular.module('userDetailApp', []);
	app.controller('userDetailController', function($scope) {
		$.ajax({
			type: "GET",
			url: "userDetails",
			async: false,
			data: {},
			success: function(data) {
				$scope.userDetails= data;
				console.log(data);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {}
		});
	   
	});
});