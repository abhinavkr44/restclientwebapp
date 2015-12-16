$(function(){
	var userApp = angular.module('userApp', ['angularUtils.directives.dirPagination']);
	userApp.controller('userDetailController', function($scope) {
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
	
	$("#currencyButton").on("click",function(){
		userApp.controller('currenciesController', function($scope) {
			$.ajax({
				type: "GET",
				url: "getListOfCurrencies",
				async: false,
				data: {},
				success: function(data) {
					console.log(data);
					var customerInfo = jQuery.parseJSON(data);
					$scope.listOfCurrencies= customerInfo.currencies;
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {}
			});
		});
	});
	
});