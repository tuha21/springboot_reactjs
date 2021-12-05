import { Component } from "react";
import { Link } from 'react-router-dom'
import '../../App.css'

class NavTop extends Component {
    render() {
        return (
            <div>
                <div className="p-2" style={{ backgroundColor: '#E3E3E3' }}>
                    <div className='row m-0'>
                        <div className='col-6'></div>
                        <div className='col-6  text-center' style={{alignItems: 'center'}}>
                            <Link to="/sges/login" className='btn'>
                                <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" className="bi bi-person-circle" width="24" height="24" viewBox="0 0 16 16">
                                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                                    <path fillRule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
                                </svg>
                                <span className='ms-2'>Đăng nhập</span>
                            </Link>
                            <span>| Miễn phí giao hàng cho đơn lớn hơn 500k |</span>
                            <Link style={{textDecoration: "none"}} className='text-dark' to='/sges/cart'>
                                <span className='ms-2'>
                                <i className="bi bi-cart"></i>
                                </span>
                                {/* <span style={{position: "relative", right: "17px", top: "1.5px"}}>5</span> */}
                            </Link>
                        </div>
                    </div>
                </div>
                <div className="navbar navbar-expand-lg navbar-dark bg-dark p-4">
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav" style={{ margin: '0 auto' }}>
                            <li className="nav-item">
                                <Link className="nav-link h5 active mb-0 ms-4 me-4"
                                    to='/sges'
                                >S G E S</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link ms-4 me-4" to='/sges' style={{
                                }}>Trang chủ</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link ms-4 me-4" to='/sges/collection'>Bộ sưu tập</Link>
                            </li>
                            {/* <li className="nav-item">
                                <Link className="nav-link ms-4 me-4" to='/sges/store'>LOOKBOOK</Link>
                            </li> */}
                            <li className="nav-item">
                                <Link className="nav-link ms-4 me-4" to='/sges/store'>Giới thiệu</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link ms-4 me-4" to='/sges/visit'>Địa chỉ</Link>
                            </li>
                            {
                                this.props.auth !== null ? <li className="nav-item">
                                    <Link className="nav-link ms-4 me-4" to='/sges/myorder'>Orders</Link>
                                </li> : <></>
                            }
                            {
                                this.props.auth !== null && (this.props.isAdmin(this.props.auth.roles) || this.props.isStaff(this.props.auth.roles)) ? <li className="nav-item">
                                    <Link className="nav-link ms-4 me-4" to='/staff'>Quản lý</Link>
                                </li> : <></>
                            }
                        </ul>
                    </div>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon" />
                    </button>
                </div>
            </div>
        );
    }
}

export default NavTop;