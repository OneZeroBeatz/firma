var app = angular.module("xws_pi_bezb.rute", ["ngRoute"]);

app.config(function($routeProvider, $locationProvider) {
    $routeProvider
    .when("/", {
    	templateUrl : "html/welcomePage.html"
    });

    $locationProvider.html5Mode(true);
});