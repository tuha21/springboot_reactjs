import { Component } from "react";
import { Link } from "react-router-dom";
import { FaMapMarkerAlt } from "react-icons/fa";
import "../../css/Visit.css";

const Visit = () => {
    return (
        <div className="container">
            <div className="row">
                <div className="col text-center pt-5">
                    <h2>Hệ thống cửa hàng</h2>
                </div>
            </div>
            <div class="row pt-5">
                <div className="col-8">
                    <iframe
                        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d10232.85400687463!2d105.74049825311074!3d21.037816830332034!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x313454b991d80fd5%3A0x53cefc99d6b0bf6f!2zVHLGsOG7nW5nIENhbyDEkeG6s25nIEZQVCBQb2x5dGVjaG5pYw!5e0!3m2!1svi!2s!4v1638698324774!5m2!1svi!2s"
                        width="100%"
                        height="600"
                        allowfullscreen=""
                        loading="lazy"
                    ></iframe>
                </div>
                <div className="col-4" style={{ borderRight: "1px solid #ced4da" }}>
                    <div className="h-100 address">
                        <Link path="#" className="row p-2 mb-4 ">
                            <div className="col-1 text-center">
                                <FaMapMarkerAlt />
                            </div>
                            <div className="col d-grid" style={{ fontFamily: "sans-serif" }}>
                                <b>SGES Trịnh Văn Bô</b>
                                <span>FĐịa chỉ: PT Polytechnic Trịnh Văn Bô</span>
                                <span>SĐT: 0966112738</span>
                            </div>
                        </Link>
                        <Link path="#" className="row p-2 mb-4">
                            <div className="col-1">
                                <FaMapMarkerAlt />
                            </div>
                            <div className="col d-grid" style={{ fontFamily: "sans-serif" }}>
                                <b>SGES Trần Thái Tông</b>
                                <span>
                                    Địa chỉ: 24 Ngách 44/64 Trần Thái Tông, Dịch Vọng Hậu, Cầu Giấy,
                                    Hà Nội
                                </span>
                                <span>SĐT: 0966112738</span>
                            </div>
                        </Link>
                        <Link path="#" className="row p-2 mb-4">
                            <div className="col-1">
                                <FaMapMarkerAlt />
                            </div>
                            <div className="col d-grid" style={{ fontFamily: "sans-serif" }}>
                                <b>SGES Hoàng Quốc Việt</b>
                                <span>
                                    Địa chỉ: 24 Phố Nghĩa Đô, Hoàng Quốc Việt, Cầu Giấy, Hà Nội
                                </span>
                                <span>SĐT: 0966112738</span>
                            </div>
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Visit;
