<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Spring MVC -HelloWorld</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css"/>
 <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/glm-ajax.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
<style>
div.dataTables_wrapper {
        margin-bottom: 3em;
    }
</style>
</head>
 <script type="text/javascript">
 $(document).ready(function() {
	    $('table.display').DataTable();
	} );
 
 ////
  $(document).ready(function(){
                $('#province').change(function(event){
                                var pro = $('#province').val();
                                $.ajax({
                                        type: "GET",
                                        data: {proname: pro},
                                        url: "GetDistrictFromProvince",
                                        success: function(responseJson){
                                                var $dis = $('#district');
                                                $dis.find('option').remove();
                                                $.each(responseJson, function(key, value){
                                                        $('<option>').val(key).text(value).appendTo($dis);
                                                });
                                        }
                                })
                });     
        });
      </script>
<body>
   <table id="" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Age</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>61</td>
                <td>$320,800</td>
            </tr>
            <tr>
                <td>Cedric Kelly</td>
                <td>Senior Javascript Developer</td>
                <td>Edinburgh</td>
                <td>22</td>
                <td>$433,060</td>
            </tr>
            <tr>
                <td>Sonya Frost</td>
                <td>Software Engineer</td>
                <td>Edinburgh</td>
                <td>23</td>
                <td>$103,600</td>
            </tr>
            <tr>
                <td>Quinn Flynn</td>
                <td>Support Lead</td>
                <td>Edinburgh</td>
                <td>22</td>
                <td>$342,000</td>
            </tr>
            <tr>
                <td>Dai Rios</td>
                <td>Personnel Lead</td>
                <td>Edinburgh</td>
                <td>35</td>
                <td>$217,500</td>
            </tr>
            <tr>
                <td>Gavin Joyce</td>
                <td>Developer</td>
                <td>Edinburgh</td>
                <td>42</td>
                <td>$92,575</td>
            </tr>
            <tr>
                <td>Martena Mccray</td>
                <td>Post-Sales support</td>
                <td>Edinburgh</td>
                <td>46</td>
                <td>$324,050</td>
            </tr>
            <tr>
                <td>Jennifer Acosta</td>
                <td>Junior Javascript Developer</td>
                <td>Edinburgh</td>
                <td>43</td>
                <td>$75,650</td>
            </tr>
            <tr>
                <td>Shad Decker</td>
                <td>Regional Director</td>
                <td>Edinburgh</td>
                <td>51</td>
                <td>$183,000</td>
            </tr>
        </tbody>
    </table>
</body>
      <form>
                Select Province: <select id="province">
                        <option>=====Provinces====</option>
                        <option value="Ha Noi">Ha Noi</option>
                        <option value="TP. HCM">TP. Ho Chi Minh</option>                        
                        <option value="Da Nang">Da Nang</option>
                </select>
                <br/><br/>
                Select District: <select id="district">
                        <option>=====Districts=====</option>
                </select>
        </form>
 
</html>