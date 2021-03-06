var PerfilController = function($scope, $http) {

	$scope.editMode = false;
	$scope.position = '';
	$scope.add = "PerfilController";
	
	$scope.reset = function() {
		//$scope.bean.nomb = '';
		$scope.editMode = false;
	};
	
	$scope.list = function() {
		$http.post('bean/list').success(function(response) {
			$scope.beanList = response;
			$scope.reset();
			$scope.setSuccess('Listando perfiles..');
		}).error(function(response) {
			$scope.setError('Error en List');
		});;
	};

	$scope.add = function(bean) {
		$http.post('bean/add', bean).success(function(response) {
			$scope.list();
			console.log('Correcto' + bean);
			$scope.setSuccess('exito al grabar.');
			$scope.reset();
		}).error(function(response) {
			console.log('Error' + response);
			$scope.setError('error al ADD');
		});
	};

	$scope.update = function(bean) {
		$http.post('bean/update/', bean).success(
				function(response) {
					$scope.list();
					$scope.setSuccess('exito al actualizar.');
					$scope.reset();
				}).error(function(response) {
			console.log(response);
		});
	};

	$scope.delete = function(bean) {
		$http.post('bean/delete', bean).success(function(response) {
			$scope.list();
			console.log('Correcto Eliminado' + bean.id);
			$scope.setSuccess('exito al borrar.');
		}).error(function(response) {
			console.log(response);
		});
	};

	$scope.set = function(pos, bean) {
		$scope.position = pos;
		$scope.bean = bean;
		$scope.editMode = true;
	};
	
	 $scope.resetError = function() {
	        $scope.error = false;
	        $scope.errorMessage = '';
	    };

	    $scope.setError = function(message) {
	        $scope.error = true;
	        $scope.success = false;
	        $scope.errorMessage = message;
	    };
	    
	    $scope.resetSuccess = function() {
	        $scope.success = false;
	        $scope.successMessage = '';
	    };

	    $scope.setSuccess = function(message) {
	        $scope.success = true;
	        $scope.error = false;
	        $scope.successMessage = message;
	    };
	    
	    

	$scope.list();
};