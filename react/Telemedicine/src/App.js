// App.js
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './pages/Login';

import Dashboard from './component/Dashboard';
import Appointment from './pages/Appointment';
import Patients from './pages/Patients';
import PatientList, { PatientLi } from './pages/PatientList';

const App = () => {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Login />} />

          <Route path='dashboard' element={<Dashboard />} />
          <Route path='appointment' element={<Appointment />} />
          <Route path='patients' element={<Patients />} />
          <Route path='patient-list' element={<PatientList/>}/>
          
         
          
          {/* <Route path='/Main/patient_list' element={<PatientList />} />          */}
          
          </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
