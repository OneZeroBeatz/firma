var welcomeKontroler = angular.module('xws_pi_bezb.welcomeKontroler', []);

welcomeKontroler.controller('welcomeCtrl', function($scope, $location, $window, welcomeServis) {
	$scope.kliknutoJedinoDugmeUAplikaciji = function(){
		welcomeServis.posaljiKliring().success(function(data){
			alert("success");
		}).error(function (data){
			alert("error");
		});
	}






});