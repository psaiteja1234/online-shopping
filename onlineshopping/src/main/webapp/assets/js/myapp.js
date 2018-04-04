$(function(){
	
	switch(menu)
	{
	case 'About us':
		$('#about').addClass('active');
		break;
	case 'Contact us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	default:{
		$('#home').addClass('active');
	 	$('#a_'+menu).addClass('active');
		break;
	}
	}


/*var products=[
	
				['1','Samsung'],
				['2','Oppo'],
				['3','Moto']
];*/


var $table=$('#productListTable');

if($table.length)
	{
	var jsonUrl='';
	if(window.categoryId=='')
		{
		jsonUrl= window.contextRoot +'/json/data/all/products';
		
		}
	else
		{
		jsonUrl= window.contextRoot +'/json/data/category/'+window.categoryId+'/products';
		}
		
	$table.DataTable({
		lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','ALL']],
		ajax:{
			url:jsonUrl,
			dataSrc:''
		},
		columns:[
			{
				data:'name'
			},
			{
				data:'brand'
			},
			{
				data:'unitPrice'
			},
			{
				data:'quantity'
			}
		]
	});
	}

});