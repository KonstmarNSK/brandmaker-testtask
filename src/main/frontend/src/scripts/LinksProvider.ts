export enum Link {
    ApiRoot = "api-root"
}



interface LinksObject {
    getLink(name: string): string | null | undefined
}

// there must be an object in global scope that has getLink method that finds links by their names (one of Link's enum values)
declare global{
    var serverLinksObject : LinksObject | null | undefined;
}


export class LinksProvider {
    private static readonly links = globalThis.serverLinksObject;

    public static getLink(link: Link): string | null {
        if(LinksProvider.links == null){
            console.log("!!!WARNING!!! There is no links object (serverLinksObject) in global scope!")
            return null;
        }

        const linkName : string = link.valueOf()
        let result = LinksProvider.links.getLink(linkName);

        if(typeof result === "undefined"){
            result = null
        }

        return result;
    }
}