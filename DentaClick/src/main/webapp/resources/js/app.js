'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives', 'ngRoute', 'ui.bootstrap', 'ngTable', 'ui.ace', 'angularFileUpload', 'nvd3ChartDirectives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
	//templateUrl goes to CONTROLLER.JAVA
    $routeProvider.when('/todo', {
        templateUrl: 'todo/layout',
        controller: TodoController
    });
    $routeProvider.when('/usuario', {
        templateUrl: 'bean/layout',
        controller: UsuarioController
    });
    $routeProvider.when('/perfil', {
        templateUrl: 'bean/layout', 
        controller: PerfilController
    });
    
    $routeProvider.otherwise({redirectTo: '/'});
}]);
