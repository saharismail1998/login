<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Course extends CI_Controller {

	/**
	 * Index Page for this controller.
	 *
	 * Maps to the following URL
	 * 		http://example.com/index.php/welcome
	 *	- or -
	 * 		http://example.com/index.php/welcome/index
	 *	- or -
	 * Since this controller is set as the default controller in
	 * config/routes.php, it's displayed at http://example.com/
	 *
	 * So any other public methods not prefixed with an underscore will
	 * map to /index.php/welcome/<method_name>
	 * @see https://codeigniter.com/user_guide/general/urls.html
	 */
	public function index()
	{
		$this->load->view('AddCourse');
	}
	public function Stdcreate()
	{
		$this->load->view('add');

	}
	public function insert()
	{
		$this->load->helper('url');
		$insert_course=$this->input->post('coures');
		$this->load->model('Course_Model');
		$this->Course_Model->insert_course($insert_course);

		redirect('/Course/Get_all');
	}
	public function update()
	{
		$courseid=$this->input->post('coursenoo');
		$coursename=$this->input->post('coursename');

		$this->load->model('Course_Model');
		$x=$this->Course_Model->update_course($courseid,$coursename);
		if ($x ==1)
		redirect('/Course/Get_all');
		else
			die('error at updating');

	}
	public function Get_all(){
		$this->load->model('Course_Model');
		$data['all'] =$this->Course_Model->Get_all();
		$this->load->view('Get_all',$data);
	}
	public function AddstdCourse(){
		$this->load->model('Course_Model');
		$d=$this->Course_Model->get_std_id();
		$this->Course_Model->Addstd_course($std_id, $cid);
		redirect('/Course/Get_all');
	}
	function delete($id){
		$this->load->model('Course_Model');
        $this->Course_Model->delete($id);
        redirect('/Course/Get_all');
	}
	function view_std(){
		$this->load->model('Course_Model');
		$datta['x']=$this->Course_Model->get_all_std();
		print_r($datta); exit;
		$this->load->view('Get_all',$datta);
	}






}
