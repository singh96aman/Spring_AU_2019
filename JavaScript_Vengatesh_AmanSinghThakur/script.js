/***************************************************************************
*PROGRAM TO CALCULATE THE TAX OF ALL EMPLOYEES*

Name 		: 	Aman Singh Thakur
Date and Time 	:	5th January, 10:00PM
Major Topic	: 	JavaScript
Sub Topics 	: 	Data Conversion, var & let, functions, function expression, Arrays, ForEach & for, __proto__ & prototype,
			constructor, bind & call & apply, IIFE & self invoking function, Datatypes, Pass By Value, Mapset, Conditional Statements,
			DOM Manipulation, Searching
****************************************************************************/

//Object Constructor
var Employee = function(name, age, id, salary, designation){
	this.name=name;
	this.age=age;
	this.id=id;
	this.salary=salary;
	this.designation=designation;
}

//Prototype
Employee.prototype.ProfileDisplay = function(){
	return ('my name is '+this.name+' age is '+this.age+' id is '+this.id+' Gross salary is '+this.salary);
}

//Algorithm, Data Conversion, function, Pass By Value
function TaxCalculator(salary){
	console.log('Tax is calculated for '+this.name);
	if(salary<=250000)
		return 0;
	else if(salary<=500000)
		return ((salary-250000)*0.05);
	else if(salary<=1000000)
		return ((250000*0.05)+((salary-500000)*0.2));
	else 
		return ((250000*0.05)+(500000*0.2)+((salary-1000000)*0.3));
}

// Array Declaration
var Leadership = [];
var TechnicalTeam = [];
var HumanResource = [];

// IIFE to initialize, mapset, array, __proto__
(function () {

	var first = new Employee('First',22,1432,1200000,'Manager');
	var second = new Employee('Second',23, 1567,2400000,'Manager');
	var third = new Employee('third',19, 1965,900000,'Technical');
	var fourth = new Employee('fourth',21, 1027,800000,'Technical');
	var fifth = new Employee('fifth',20, 1069,850000,'Technical');
	var sixth = new Employee('sixth',20, 1960,700000,'HR');
	var seventh = new Employee('seventh',25, 9964,1000000,'HR'); 

	Leadership.push(first);
	Leadership.push(second);
	TechnicalTeam.push(third);
	TechnicalTeam.push(fourth);
	TechnicalTeam.push(fifth);
	HumanResource.push(sixth);
	HumanResource.push(seventh);

	var map = new Object();
	map['Leader']=2;
	map['Tech']=3;
	map['HR']=2;
	console.log(map);

	//Doesn't work because an Object's prototype is already defined as TaxCalculator
	//var newFunc = {
    	//	welcome : function () {
        //	console.log('Say Hi');
    	//	}
	//};
	//first.__proto__ = newFunc;
})();

// IIFE to execute, For, ForEach, call, bind, apply, prototype
(function () {
	console.log('\n\n\nTHE LEADERSHIP TEAM');
	for(let i=0; i<Leadership.length; i++){
		console.log(Leadership[i].ProfileDisplay());
		var tax = TaxCalculator.call(Leadership[i], Leadership[i].salary);
		console.log('Net Salary is '+(Leadership[i].salary-tax));
		//Leadership[i].welcome();
	}

	console.log('\n\n\nTHE TECHNICAL TEAM');
	TechnicalTeam.forEach(function(emp){
		console.log(emp.ProfileDisplay());
		var temp = TaxCalculator.bind(emp);
		var tax = temp(emp.salary);
		console.log('Net Salary is '+(emp.salary-tax));
	});

	console.log('\n\n\nTHE HR TEAM');
	HumanResource.forEach(function(emp){
		console.log(emp.ProfileDisplay());
		var tax = TaxCalculator.apply(emp, [emp.salary]);
		console.log('Net Salary is '+(emp.salary-tax));
	});
})();

//DOM Manipulation
function getInfo(){
	var temp = document.getElementById('val').value;
	for(let i=0; i<Leadership.length; i++){
		if(Leadership[i].name==temp)
			document.getElementById('txt1').innerHTML += Leadership[i].ProfileDisplay(); 
	}
	for(let i=0; i<TechnicalTeam.length; i++){
		if(TechnicalTeam[i].name==temp)
			document.getElementById('txt1').innerHTML += TechnicalTeam[i].ProfileDisplay(); 
	}
	for(let i=0; i<HumanResource.length; i++){
		if(HumanResource[i].name==temp)
			document.getElementById('txt1').innerHTML += HumanResource[i].ProfileDisplay(); 
	}
}