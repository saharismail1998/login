<?php
?>

<form method="post" action="<?=base_url('Course/insert')?>">
	<div class="form-group">
		<label for="id">Course id:</label>
		<input type="text" class="form-control" placeholder="Course id" id="Courseid" readonly>
	</div>
	<div class="form-group">
		<label for="name">Course Name:</label>
		<input type="text" class="form-control" placeholder="Course Name" id="pwd" name="coures">
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form>
