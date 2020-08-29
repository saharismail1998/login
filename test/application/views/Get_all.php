<!DOCTYPE html>
<html lang="en">
<head>
	<title>Bootstrap Example</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
	<h2>Basic Table</h2>
	<p>The .table class adds basic styling (light padding and horizontal dividers) to a table:</p>
<a href="index">add Course</a>
	<table class="table">
		<thead>
		<tr>
			<th>Course Id</th>
			<th>Course name</th>
			<th> delete</th>
			<th> edit</th>
			<th> Add Students</th>
		</tr>
		</thead>
		<tbody>
		<?php  $count=0;
		foreach($all -> result() as $row):?>

		<tr>
			<td><?=++$count;?></td>
			<td><?=$row->cname;?></td>
			<td> <a href="delete/<?=$row->cid;?>">delete</a> </td>
			<td> <a href="javascript;" onclick="get('<?=$row->cid;?>','<?=$row->cname;?>');" data-toggle="modal" data-target="#myModal">edit </a> </td>
			<td> <a href="javascript;" onclick="get('<?=$row->cid;?>','<?=$row->cname;?>');" data-toggle="modal" data-target="#stdModal">Add </a> </td>
		</tr>



		<?php endforeach;?>




		</tbody>
	</table>
	<div id="myModal" class="modal fade" role="dialog">
		<form method="post" action="<?=base_url('Course/update')?>">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modal Header</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" name="coursenoo" id="coursenoo" value="">
					<label>course name</label><input type="text" name="coursename" id="coursename" value="">

				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Submit</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>

		</form></div>

</div>

<div id="stdModal" class="modal fade" role="dialog">
	<form method="post" action="<?=base_url('Course/AddstdCourse')?>">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modal Header</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" name="coursenoo" id="coursenoo" value="">

					<table>
						<tr>
							<td>
								<select class="form-group">
									<option class='form-control' type='text' name='stock'></option>
									<?php
									foreach($x -> result() as $row):?>

										<option><?php $row->sname;?></option>

						<?php endforeach;?>


								</select>
							</td>
							<td><button type="submit">Save</button></td>
						</tr>
						<tr>
							<td>
								<select name="cars" id="cars">
									<option value="volvo">Volvo</option>
									<option value="saab">Saab</option>
									<option value="mercedes">Mercedes</option>
									<option value="audi">Audi</option>
								</select>
							</td>
							<td><button type="submit">Save</button></td>
						</tr>
						<tr>
							<td>
								<select name="cars" id="cars">
									<option value="volvo">Volvo</option>
									<option value="saab">Saab</option>
									<option value="mercedes">Mercedes</option>
									<option value="audi">Audi</option>
								</select>
							</td>
							<td><button type="submit">Save</button></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Submit</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>

	</form></div>

</div>
<script>
	function get(id,name){
		$('#coursenoo').val(id);
		$('#coursename').val(name);
		show_modal('#myModal');
	}
</script>
</body>
</html>
