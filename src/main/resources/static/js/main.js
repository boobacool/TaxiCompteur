/**
 * 
 */
$(document).ready(function(){
	$('.table .eBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();
		$.get(href,function(taxi,status){
			$('.myForm #id').val(taxi.id);
			$('.myForm #immat').val(taxi.immat);
			$('.myForm #dateservice').val(taxi.dateservice);
		});
		$('.myForm #exampleModal').modal();
	});
	
	$('.nBtn').on('click',function(event){
		event.preventDefault();
		$('.myForm #id').val('');
		$('.myForm #immat').val('');
		$('.myForm #dateservice').val('');
		$('.myForm #exampleModal').modal();
	});
	
	$('.table .sBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#modalSupp #delRef').attr('href',href)
		$('#modalSupp').modal();
	});
});