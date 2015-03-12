var UsuarioController = function($scope, $http) {
	$scope.editMode = false;
	$scope.position = '';
	$scope.controller = "UsuarioController";
	   
	$scope.listPerfil = function() {
		$http.post('usuario/listPerfil.json')
		.success(function(data, status, headers, config) {
        	$scope.perfilList = data;	        	
        })
        .error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
        });		    
    };		
    
 	$scope.list = function() {
		$http.post('usuario/list.json')
		.success(function(response) {
			$scope.beanList = response;
		});
	};

	$scope.reset = function() {
		$scope.bean.nomb = '';
		$scope.bean.pass = '';
		$scope.editMode = false;
	};

	$scope.add = function(bean) {
		$http.post('usuario/add', bean).success(function(response) {
			$scope.list();
			console.log('Correcto' + bean);
			$scope.setSuccess('Se guardo con exito.');
		}).error(function(response) {
			console.log('Error' + response);
			$scope.setError('error add');
		});
		$scope.reset();
	};

	$scope.update = function(bean) {
		$http.post('usuario/update/', bean).success(
				function(response) {
					$scope.list();
					$scope.editMode = false;
					$scope.setSuccess('Se actualizo con exito.');
				}).error(function(response) {
			console.log(response);
		});
		$scope.reset();
	};

	$scope.delete = function(bean) {
		$http.post('usuario/delete', bean).success(function(response) {
			$scope.list();
			console.log('Correcto Eliminado' + bean.id);
			$scope.setSuccess('Se borro con exito.');
		}).error(function(response) {
			console.log(response);
		});
		$scope.reset();
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
	$scope.listPerfil();
};