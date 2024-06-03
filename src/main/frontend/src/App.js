import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Login from "./pages/Login";
import Main from "./pages/Main";
import Edit from "./pages/Edit";
import MyPage from "./pages/MyPage";

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path="/login_page" element={<Login/>}/>
          <Route path="/main" element={<Main/>}/>
          <Route path="/edit" element={<Edit/>}/>
          <Route path={"/mypage"} element={<MyPage/>}/>
        </Routes>
      </BrowserRouter>
  );
}

export default App;
