
var app = angular.module("app", [ "ngRoute" ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'home.html'
	});
	$routeProvider.when('/user', {
		templateUrl : 'user.html',
		controller : 'userCtrl'
	});
	/*$routeProvider.when('/login', {
		templateUrl : 'login.html',
		controller : 'loginCtrl'
	});*/
	$routeProvider.when('/restaurants', {
		templateUrl : 'restaurant.html',
		controller : 'restaurantCtrl'
	});
	$routeProvider.when('/items', {
		templateUrl : 'items.html',
		controller : 'itemsCtrl'
	});
	$routeProvider.otherwise({
		redirectTo : '/home'
	});
} ]);

app.controller("restaurantCtrl", function($scope, $http) {

	$scope.fetchRestaurant = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:9080/restaurant/getAll'
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.restaurants = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	
	
	$scope.saveRestaurant = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:9080/restaurant/add',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.restaurant
		}).success(function(data, status) {
			console.log(data);
			$scope.fetchRestaurant();
			$scope.restaurants = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};

});

app.controller("userCtrl", function($scope, $http) {
	
	$scope.login = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:9080/user/login',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.restaurant
		}).success(function(data, status) {
			console.log(data);
			if(data){
				//alert("Success");
				$scope.fetchRestaurant();
				$scope.restaurants = data;
			}
			else
				alert("Request failed");
			//$scope.fetchItem();
			//$scope.items = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};

	$scope.fetchUser = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:9080/user/getallUsers'
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.users = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	
	
	$scope.saveUser = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:9080/user/addUser',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.user
		}).success(function(data, status) {
			console.log(data);
			$scope.fetchUser();
			$scope.users = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	
	});


app.controller("itemsCtrl", function($scope, $http) {

	$scope.fetchItem = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:9080/restaurant/getallItems'
		}).success(function(data, status) {
			//console.log(data);
			//$scope.status = status;
			$scope.items = data;
		}).error(function(data, status) {
			//$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	
	
	$scope.saveItem = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:9080/restaurant/addItems',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.item
		}).success(function(data, status) {
			console.log(data);
			if(data){
				//alert("Success");
				$scope.fetchItem();
				$scope.items = data;
			}
			else
				alert("Request failed");
			//$scope.fetchItem();
			//$scope.items = data;
		}).error(function(data, status) {
			//$scope.status = status;
			$scope.data = "Request failed";
		});
	};


		
		
});
