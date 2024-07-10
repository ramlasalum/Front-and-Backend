import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Button, Table } from 'react-bootstrap';
import UpdatePatient from './PatientList'; 
import './PatientList.css';

const PatientList = () => {
  const [patients, setPatients] = useState([]);
  const [editingPatient, setEditingPatient] = useState(null);

  useEffect(() => {
    fetchPatients();
  }, []);

  const fetchPatients = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/v1/patient/get-patient');
      setPatients(response.data);
    } catch (error) {
      console.error('Error fetching patients', error);
    }
  };

  const deletePatient = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/v1/patient/post-patient/${id}`);
      setPatients(patients.filter(patient => patient.id !== id));
    } catch (error) {
      console.log(`Deleting patient with user_Id: ${id}`);
      console.error("Error deleting patient", error.response ? error.response.data : error);
    }
  };

  const startEditing = (patient) => {
    setEditingPatient(patient);
  };

  const cancelEditing = () => {
    setEditingPatient(null);
  };

  const handleUpdate = (id) => {
    fetchPatients();
    setEditingPatient(id);
  };

  return (
    <>
      {editingPatient ? (
        <UpdatePatient
          patient={editingPatient} 
          onCancel={cancelEditing} 
          onUpdate={handleUpdate} 
        />
      ) : (
        <>
          <Table striped bordered hover>
            <thead>
              <tr>
                <th>id</th>
                <th>Name</th>
                <th>Address</th>
                <th>Age</th>
                <th>Email</th>
                <th>Phone</th>
                
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {patients.map((patient) => (
                <tr key={patient.id}>
                  <td>{patient.id}</td>
                  <td>{patient.name}</td>
                  <td>{patient.address}</td>
                  <td>{patient.age}</td>
                  <td>{patient.email}</td>
                  <td>{patient.phone}</td>
                  
                  <td>
                    <button type="button" style={{ backgroundColor: 'green', color: 'white' }} onClick={() => startEditing(patient)}>Update</button>
                    <button type="button" style={{ backgroundColor: 'red', color: 'white' }} onClick={() => deletePatient(patient.user_Id)}>Delete</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
          
        </>
      )}
    </>
  );
}

export default PatientList;





/*import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

export const PatientLi = () => {
  const [data, setData] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    axios.get('http://localhost:8080/api/v1/patient/get-patient/')
      .then((response) => {
        setData(response.data);
      })
  }, []);

  const handleDelete = (id) => {
    axios.delete(`http://localhost:8080/api/v1/patient/post-patient/${id}`)
      .then((response) => {
        setData(data.filter((item) => item.patientId !== id));
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const handleUpdate = (id) => {
    navigate(`/updatePatient/${id}`);
  };

  return (
    <div className="PatientList">
      <h2>Patient List</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Age</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item, index) => (
            <tr key={index}>
              <td>{item.patientId}</td>
              <td>{item.patientName}</td>
              <td>{item.patientAddress}</td>
              <td>{item.patientAge}</td>
              <td>{item.patientEmail}</td>
              <td>{item.patientPhone}</td>
              <td>
                <button type="button" style={{ backgroundColor: 'green', color: 'white' }} onClick={() => handleUpdate(item.patientId)}>Update</button>
                <button type="button" style={{ backgroundColor: 'red', color: 'white' }} onClick={() => handleDelete(item.patientId)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};*/