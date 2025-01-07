import { Toaster } from "react-hot-toast"
import { Outlet } from "react-router-dom"
import Header from "./Header"


const Layout = () =>{
    return(
        <div>
        <Toaster />
        <Header />
        <div className="min-h-[1000px] bg-[#fff8f7]">
        
            <Outlet />
  
          
        </div>
      </div>

    )
}

export default Layout;