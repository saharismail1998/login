<?php
class Course_Model extends CI_Model{
	public function insert_course ($course){

		$data=array('cname' =>$course );
		return $this->db->insert('coursetb',$data);
	}
	public function update_course ($id,$course){

		$data=array('cname' =>$course );
		$this->db->where('cid',$id);
		return $this->db->update('coursetb',$data);

	}
	public function Get_all(){
   $res = $this->db->query("select * from coursetb  ");
   return $res;
	}
	function delete($id){
		$this->db->where('cid',$id);
		return $this->db->delete('coursetb');
	}
	public function Get($id){
		$res = $this->db->query("select * from coursetb where cid =".$id);
		return $res;
	}
	public function Addstd_course($std_id, $course_id){

	}
	public function get_std_id($name){
		$res = $this->db->query("select * from student where sname =".$name);
		return $res;
	}
	public function get_all_std(){
		$res = $this->db->query("select sname from student_tb");
		return $res;
	}

}
