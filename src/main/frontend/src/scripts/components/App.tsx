import React from 'react';
import {Link, LinksProvider} from "../LinksProvider";

export default function App() {
    return <div>
        <h1>Hello, world!</h1>
        <a href={LinksProvider.getLink(Link.ApiRoot) || "no-link-found"}> someLink </a>
    </div>
}
