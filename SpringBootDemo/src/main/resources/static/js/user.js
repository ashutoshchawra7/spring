	var mainApp = angular.module("mainApp", []);

		mainApp.controller('userController', function($scope, $http) {
			
			$scope.getList = function() {
				/*alert('getList');*/
				$http(
						{
							url:'userlist',
							method:'GET'
						}		
						).success(function(response){
							console.log(response);
							$scope.names = response;
						})
			}
			$scope.getList();
			$scope.reset = function() {
				$scope.firstName = '';
				$scope.lastName = '';
				$scope.email = '';
			}
			$scope.submit = function() {
				/*alert($scope.firstName);*/
				$http({
					url : 'addusers',
					method : 'POST',
					params : {fName:$scope.firstName,lName:$scope.lastName,email:$scope.email}
				}).then(function(response) {
					console.log(response);
					$scope.names.push({fName:$scope.firstName,lName:$scope.lastName,email:$scope.email})
				})
			}

			$scope.reset();
		});